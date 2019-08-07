CREATE SEQUENCE groups_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

-- Table group
CREATE TABLE groups
(
  id bigint NOT NULL DEFAULT nextval('groups_id_seq'),
  group_name character varying(32) NOT NULL,
  modules character varying(1024) NOT NULL,
  CONSTRAINT group_id_pk PRIMARY KEY (id)
);


CREATE SEQUENCE users_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
-- Table users
CREATE TABLE users
(
  id bigint NOT NULL DEFAULT nextval('users_id_seq'),
  email character varying(128) NOT NULL,
  name character varying(32) NOT NULL,
  groups_id bigint,
  CONSTRAINT users_id_pk PRIMARY KEY (id),
  CONSTRAINT merchant_reseller_issuer_id_fk FOREIGN KEY (groups_id)
  REFERENCES groups (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);
