
-- DROP DES INDEX
DROP INDEX idx_t_actions IF EXISTS;
DROP INDEX idx_t_actions_0 IF EXISTS;
DROP INDEX idx_t_conges IF EXISTS;
DROP INDEX idx_t_projet IF EXISTS;
DROP INDEX idx_t_worker IF EXISTS;
DROP INDEX idx_t_worker_0 IF EXISTS;
DROP INDEX idx_t_livrables IF EXISTS;

-- DROP DES FOREIGN KEY
ALTER TABLE t_worker DROP CONSTRAINT fk_t_worker;
ALTER TABLE t_worker DROP CONSTRAINT fk_t_worker_0;
ALTER TABLE t_projet DROP CONSTRAINT fk_t_projet;
ALTER TABLE t_conges DROP CONSTRAINT fk_t_conges;
ALTER TABLE t_regroupe DROP CONSTRAINT fk_t_regroupe;
ALTER TABLE t_regroupe DROP CONSTRAINT fk_t_regroupe_0;
ALTER TABLE t_livrable DROP CONSTRAINT fk_t_livrable;
ALTER TABLE t_actions DROP CONSTRAINT fk_t_actions_t_users_ctu;
ALTER TABLE t_actions DROP CONSTRAINT fk_t_actions_t_users_aiv;

-- DROP DES TABLES
DROP TABLE t_regroupe IF EXISTS;
DROP TABLE t_livrable IF EXISTS;
DROP TABLE t_worker IF EXISTS;
DROP TABLE t_projet IF EXISTS;
DROP TABLE t_conges IF EXISTS;
DROP TABLE t_actions IF EXISTS;
DROP TABLE t_users IF EXISTS;