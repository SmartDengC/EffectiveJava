package org.hahadeng.dp.myiterator;

import java.io.File;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * @author 邓聪
 * @since 2025/6/4 10:47
 *
 * <a href="https://github.com/implement-study">代码仓库</a>
 */
public class PeopleFile implements Iterable<People> {
    private final File file;

    public PeopleFile(File file) {
        this.file = file;
    }

    @Override
    public Iterator<People> iterator() {
        return new PeopleFileIterator();
    }

    class PeopleFileIterator implements Iterator<People> {

        List<People> peopleList = readPeopleFromFile();
        int cursor = 0;

        private List<People> readPeopleFromFile() {
            try {
                return Files.readAllLines(file.toPath()).stream().map(line -> {
                    String substring = line.substring(1, line.length() - 1);
                    String[] split = substring.split(",");
                    return new People(split[0], Integer.parseInt(split[1]));
                }).collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor != peopleList.size();
        }

        @Override
        public People next() {
            if (cursor >= peopleList.size()) {
                throw new NoSuchElementException();
            }
            // 如何判断还有元素？
            int currentCursor = cursor;
            cursor++;
            return peopleList.get(currentCursor);
        }
    }
}
