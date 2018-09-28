package edu.ncsu.executors;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.google.gson.JsonObject;
import edu.ncsu.config.Properties;
import edu.ncsu.executors.models.ClassMethods;
import edu.ncsu.executors.models.Function;
import edu.ncsu.store.StoreUtils;
import edu.ncsu.utils.Utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class MetadataExtractor {

    private static final Logger LOGGER = Logger.getLogger(MetadataExtractor.class.getName());

    private ClassMethods classMethods;

    public MetadataExtractor(String filePath) {
        classMethods = new ClassMethods(filePath);
    }

    public void extract() {
        LOGGER.info(String.format("Extracting metadata for class: %s.%s",
                classMethods.getPackageName(), classMethods.getClassName()));
        JsonObject metadata = new JsonObject();
        for (Method method: classMethods.getMethods()) {
            Function function = classMethods.getFunction(method);
            metadata.add(function.getName(), function.getMetaData());
        }
        LOGGER.info("Writing ... ");
        String writeFolder = Utils.pathJoin(Properties.CODEJAM_FUNCTIONS_META_FOLDER,
                classMethods.getPackageName().replaceAll("\\.", File.separator));
        Utils.mkdir(writeFolder);
        String writeFile = Utils.pathJoin(writeFolder, String.format("%s.json", classMethods.getClassName()));
        StoreUtils.saveJsonObject(metadata, writeFile, true);
    }


}
