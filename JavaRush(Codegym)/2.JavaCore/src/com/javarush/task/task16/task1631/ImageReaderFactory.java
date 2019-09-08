package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {


    public static ImageReader getImageReader(ImageTypes imageTypes) throws IllegalArgumentException {
        if (imageTypes != null) {
            if (imageTypes.equals(imageTypes.BMP)) {
                return new BmpReader();
            } else if (imageTypes.equals(imageTypes.JPG)) {
                return new JpgReader();
            } else if (imageTypes.equals(imageTypes.PNG)) {
                return new PngReader();
            } else {
                throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }


}

