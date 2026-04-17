package db.migration.dev;

import db.migration.support.SeedUserMigrationSupport;

public class V2__seed_dev_user extends SeedUserMigrationSupport {

    @Override
    protected String defaultUsername() {
        return "dev_admin";
    }

    @Override
    protected String usernameEnvVar() {
        return "DEV_SEED_USERNAME";
    }

    @Override
    protected String passwordEnvVar() {
        return "DEV_SEED_PASSWORD";
    }

    @Override
    protected String defaultPassword() {
        return "password123";
    }
}
