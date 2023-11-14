package org.geekwys.righthooks.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class MediaUtils {

    // Compress media data
    public static byte[] supercompress(byte[] input) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(input.length);
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(input);
        deflater.finish();
        byte[] buffer = new byte[4 * 1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        deflater.end();
        return outputStream.toByteArray();
    }

    // Decompress media data
    public static byte[] decompress(byte[] compressedData) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressedData.length);
        Inflater inflater = new Inflater();
        inflater.setInput(compressedData);
        byte[] buffer = new byte[4 * 1024];
        while (!inflater.finished()) {
            try {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            } catch (DataFormatException e) {
                e.printStackTrace();
            }
        }
        inflater.end();
        return outputStream.toByteArray();
    }

}
