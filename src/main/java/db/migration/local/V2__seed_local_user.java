package db.migration.local;

import db.migration.support.SeedUserMigrationSupport;

public class V2__seed_local_user extends SeedUserMigrationSupport {

    @Override
    protected String defaultUsername() {
        return "local_admin";
    }

    @Override
    protected String usernameEnvVar() {
        return "LOCAL_SEED_USERNAME";
    }

    @Override
    protected String passwordEnvVar() {
        return "LOCAL_SEED_PASSWORD";
    }

    @Override
    protected String defaultPassword() {
        return "password123";
    }
}
