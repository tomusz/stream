public class ApplicationBuilder {

    private static final Application application = new Application();

    public ApplicationBuilder provideSensitiveProperties() {
        application.provideSensitivePropertiesKeys();
        return this;
    }

    public ApplicationBuilder encodeSensitiveProperties() {
        application.encodeAppProperties();
        return this;
    }

    public Application build() {
        return application;
    }
}