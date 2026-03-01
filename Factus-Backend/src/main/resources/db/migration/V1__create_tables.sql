CREATE TABLE roles (
    id SERIAL NOT NULL,
    name_rol VARCHAR(100) NOT NULL,
    CONSTRAINT id_rol_pk PRIMARY KEY (id)
);

CREATE TABLE users (
    id  SERIAL NOT NULL,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    id_rol NUMERIC NOT NULL,

    CONSTRAINT id_user_pk PRIMARY KEY (id),
    CONSTRAINT id_user_rol_fk FOREIGN KEY (id_rol)
        REFERENCES roles (id)
        ON DELETE RESTRICT
);