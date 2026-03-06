CREATE TABLE roles (
    id SERIAL NOT NULL,
    name_rol VARCHAR(100) NOT NULL,
    CONSTRAINT id_rol_pk PRIMARY KEY (id),
    CONSTRAINT role_name_unique UNIQUE (name_rol)
);
DROP TABLE users;

CREATE TABLE users (
    id  SERIAL NOT NULL,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    rol_id INTEGER NOT NULL,
    company_id INTEGER NOT NULL,

    CONSTRAINT id_user_pk PRIMARY KEY (id),
    CONSTRAINT id_user_rol_fk FOREIGN KEY (rol_id)
        REFERENCES roles (id)
        ON DELETE RESTRICT,
    CONSTRAINT id_user_company_fk FOREIGN KEY (company_id)
        REFERENCES companies (id)
        ON DELETE RESTRICT,
    CONSTRAINT user_email_unique UNIQUE (email)
);

CREATE TABLE companies (
    id SERIAL NOT NULL,
    name_company VARCHAR(100) NOT NULL,
    ruc_nit VARCHAR(40) NOT NULL,
    tax_address VARCHAR(150) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    CONSTRAINT id_Company_pk PRIMARY KEY (id),
    CONSTRAINT company_name_unique UNIQUE (name_company)
);



CREATE TABLE app_settings (
    id SERIAL NOT NULL,
    company_id INTEGER NOT NULL,
    settings JSONB NOT NULL,
    CONSTRAINT app_settings_id_pk PRIMARY KEY (id),
    CONSTRAINT app_settings_company_id_fk FOREIGN KEY (company_id)
            REFERENCES companies (id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT
);