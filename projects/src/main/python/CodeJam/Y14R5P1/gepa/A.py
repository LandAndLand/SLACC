import sys
import bisect


def compute(N, p, q, r, s):
    a = [0]
    last = 0
    for i in xrange(N):
        x = (i * p + q) % r + s
        last += 2 * x
        a.append(last)
    best = 0.0
    if a[-1] == 0:
        return 0.0
    q = (0,0,0)
    for i in xrange(len(a)):
        first = a[i]
        need = first + (a[-1] - first) / 2
        pos = bisect.bisect_left(a, need)
        second = a[pos] - first
        third = a[-1] - first - second
        m = a[-1] - max(first, second, third)
        if float(m) / float(a[-1]) > best:
            q = (i, pos)
            best = float(m) / float(a[-1])
        if pos - 1 > i:
            second = a[pos - 1] - first
            third = a[-1] - first - second
            m = a[-1] - max(first, second, third)
            if float(m) / float(a[-1]) > best:
                best = float(m) / float(a[-1])
                q = (i, pos - 1)
    return best


def parse(infile):
    N, p, q, r, s = map(int, infile.readline().strip().split())
    return N, p, q, r, s


def _main():
    sys.setrecursionlimit(100000)
    infile = open("codejam/test_files/Y14R5P1/A.in")
    T = int(infile.readline().strip())
    for i in xrange(T):
        data = parse(infile)
        result = compute(*data)
        print "Case #%d: %s" % (i + 1, result)
    infile.close()

if __name__ == "__main__":
    _main()

