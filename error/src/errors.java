public class errors {

    public void prepareErrorList(){

        errors.put(new Exception(), Integer.MIN_VALUE);
        errors.put(new NullPointerException(), 10);
        errors.put(new NoSuchFileException("The file could not be found. Sorry for the inconvience"), 20);
        errors.put(new IllegalStateException(), 30);
        errors.put(new FileNotFoundException(), 200);
        errors.put(new AccessDeniedException("The account "+System.getProperty("user.name")+"\nhas not the privileges to do this action."), 40);
        errors.put(new ArrayIndexOutOfBoundsException(),  50);
        errors.put(new UnsupportedOperationException(), 60);
        errors.put(new IOException(), 70);
        errors.put(new MalformedURLException(), 80);
        errors.put(new IllegalArgumentException(), 90);

        desc.put(10,"NullPointerException - w którymś momencie w kodzie została napotkana wartość null.");
        desc.put(30,"The value or component has tried to gain illegal state.");
        desc.put(200, "The given file hasn't been found, asure that you gave\nan absolute path and the file exists!");
        desc.put(50, "The index is out of range; it means that the method tried to access the index which is\n"
                + "not in that array.");
        desc.put(60, "Requested operation is not supported at the moment.");
        desc.put(70, "The problem was occured while operating on Input/Output streams.");
        desc.put(90, "The argument given was illegal.");
        desc.put(80, "Given URL is malformed, check\nthat you have write a proper URL address");
    }

}
