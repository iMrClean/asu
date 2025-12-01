--liquibase formatted sql

--changeset stepninkv:prepare_databasechangelog
COMMENT ON TABLE DATABASECHANGELOG IS 'Таблица хранящая информацию о выполненных changeset-ах Liquibase';

COMMENT ON COLUMN DATABASECHANGELOG.ID IS 'Идентификатор changeset-а';
COMMENT ON COLUMN DATABASECHANGELOG.AUTHOR IS 'Автор changeset-а';
COMMENT ON COLUMN DATABASECHANGELOG.FILENAME IS 'Путь до файла с changelog';
COMMENT ON COLUMN DATABASECHANGELOG.DATEEXECUTED IS 'Дата и время когда changeset был выполнен';
COMMENT ON COLUMN DATABASECHANGELOG.ORDEREXECUTED IS 'Порядок выполнения changeset';
COMMENT ON COLUMN DATABASECHANGELOG.EXECTYPE IS 'Описание как changeset был выполнен';
COMMENT ON COLUMN DATABASECHANGELOG.MD5SUM IS 'Хеш выполненного changeset-а';
COMMENT ON COLUMN DATABASECHANGELOG.DESCRIPTION IS 'Описание операций changeset-а';
COMMENT ON COLUMN DATABASECHANGELOG.COMMENTS IS 'Комментарий changeset-а';
COMMENT ON COLUMN DATABASECHANGELOG.TAG IS 'Тег для changeset-ов с тегом';
COMMENT ON COLUMN DATABASECHANGELOG.LIQUIBASE IS 'Версия Liquibase';
COMMENT ON COLUMN DATABASECHANGELOG.CONTEXTS IS 'Context который использовался при выполнении changeset-а';
COMMENT ON COLUMN DATABASECHANGELOG.LABELS IS 'Метка которая использовалась при выполнении changeset-а';
COMMENT ON COLUMN DATABASECHANGELOG.DEPLOYMENT_ID IS 'Changeset-ы которые были выполнены вместе будут иметь одинаковый идентификатор';

--changeset stepninkv:prepare_databasechangeloglock
COMMENT ON TABLE DATABASECHANGELOGLOCK IS 'Таблица для контроля, что только один экземпляр Liquibase в данный выполняет изменения в БД';

COMMENT ON COLUMN DATABASECHANGELOGLOCK.ID IS 'Идентификатор блокировки';
COMMENT ON COLUMN DATABASECHANGELOGLOCK.LOCKED IS 'Признак блокировки';
COMMENT ON COLUMN DATABASECHANGELOGLOCK.LOCKGRANTED IS 'Дата выдачи блокировки';
COMMENT ON COLUMN DATABASECHANGELOGLOCK.LOCKEDBY IS 'Кем взята блокировка';
