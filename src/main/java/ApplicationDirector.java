public class ApplicationDirector {

    private final ApplicationBuilder applicationBuilder;

    public ApplicationDirector(ApplicationBuilder applicationBuilder) {
        this.applicationBuilder = applicationBuilder;
    }

    public Application buildApplication() {
        return applicationBuilder.provideSensitiveProperties()
                .encodeSensitiveProperties()
                .build();
    }
}
