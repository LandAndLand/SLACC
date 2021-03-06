#!/usr/bin/env bash

#SBATCH --job-name file_meta_extract
#SBATCH -N 1
#SBATCH -p opteron
# Use modules to set the software environment

if [ -z "$1" ]
then
    echo "Run: sh scripts/python/extract_file_metadata.sh 'Dataset' args ... "
    exit 1
fi

cd src/main/python
if [ -z "$2" ]
then
    python mains/file_metadata.py $1
else
    python mains/file_metadata.py $1 $2
fi


## Codejam
#sbatch scripts/python/extract_file_metadata.sh CodeJam
#--- OR ---
#sbatch scripts/python/extract_file_metadata.sh CodeJam Y11R5P1
#sbatch scripts/python/extract_file_metadata.sh CodeJam Y12R5P1
#sbatch scripts/python/extract_file_metadata.sh CodeJam Y13R5P1
#sbatch scripts/python/extract_file_metadata.sh CodeJam Y14R5P1
