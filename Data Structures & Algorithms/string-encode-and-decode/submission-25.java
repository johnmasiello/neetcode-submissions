class Solution {
    private static final String ENCODING = "ISO-8859-1";
    public String encode(List<String> strs) throws Exception {
        /*
         * 1.convert a string to byte[]
         * 2. take byte[].length and store in a byte and prepend that byte to byte[]
         * 3. Do for each of strings
         * 4. concatenate each byte[] with the size byte preceding.
         * 5. get string from byte[] as result
         */

         List<Byte> byteArray = new ArrayList<>();

         for (String str : strs) {
            byte[] bytes = str.getBytes(ENCODING);
            byteArray.add((byte) bytes.length);
            // System.out.println(Byte.toUnsignedInt((byte) bytes.length));
            addBytes(bytes, byteArray);
            // System.out.println(byteArray);
         }
         byte[] themBytes = toArray(byteArray);
         return new String(themBytes, ENCODING);
    }

    public List<String> decode(String str) throws Exception {
        /*
        * 1. get byte[] from input string
        * 2. take index in byte array as 0
        * 3. read that byte as integer
        * 4. add previous index to that integer as updated index
        * 5. Take the byte as integer from byte[index]
        * 6. repeat 3-5 until index = byte[].length
        * 7. You were supposed to take each sub array of bytes and convert to string
        * 8. Make sure using same string format to decode as encode.
        */
        byte[] arr = str.getBytes(ENCODING);
        // System.out.println(Arrays.toString(arr));

        int index = 0;
        List<String> strList = new ArrayList<>();

        while (index < arr.length) {
            int wordLength = Byte.toUnsignedInt(arr[index]);

            // Move past the word size byte
            index++;
            byte[] wordBytes = toArray(arr, index, index + wordLength);
            strList.add(new String(wordBytes, ENCODING));
            index += wordLength;
        }
        return strList;
    }

    static void addBytes(byte[] bytes, List<Byte> byteArray) {
        for (byte b: bytes) {
            byteArray.add(b);
        }
    }

    static byte[] toArray(List<Byte> bList) {
        byte[] arr = new byte[bList.size()];

        int index = 0;
        for (byte b : bList) {
            arr[index] = b;
            index++;
        }
        return arr;
    }

    static byte[] toArray(byte[] src, int start, int end) {
        byte[] dest = new byte[end - start];

        for (int i = 0; i < dest.length; i++) {
            dest[i] = src[start + i];
        }
        return dest;
    }
}
