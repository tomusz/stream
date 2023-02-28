public class Main {

    public static void main(String[] args) {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder();
        ApplicationDirector applicationDirector = new ApplicationDirector(applicationBuilder);
        Application application = applicationDirector.buildApplication();
        application.printMapKeyAndValues();
    }
}