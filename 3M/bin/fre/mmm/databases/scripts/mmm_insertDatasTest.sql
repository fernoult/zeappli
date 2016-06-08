
-- USERS
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer) 
	VALUES('ldebat', 'DEBAT', 'Laurent', 'laurent.debat@capgemini.com', '0000000000', 'CapGemini', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('fernoult', 'ERNOULT', 'François', 'francois.ernoult@capgemini.com', '0000000000', 'CapGemini', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('bgehu', 'GEHU', 'Bruno', 'bruno.gehu@capgemini.com', '0000000000', 'CapGemini', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('jiando', 'DO', 'Jian-Ying', 'jian-ying.do@capgemini.com', '0000000000', 'CapGemini', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('nfabre', 'FABRE', 'Nicolas', 'nicolas.fabre@capgemini.com', '0000000000', 'CapGemini', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('fjouanne', 'JOUANNE', 'Fabien', 'fabien.jouanne@c-s.fr', '0000000000', 'CommunicationServices', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('rdupont', 'DUPONT', 'Romain', 'romain.dupont@c-s.fr', '0000000000', 'CommunicationServices', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('schacornac', 'CHACORNAC', 'Simon-Pierre', 'simon-pierre.chacornac@c-s.fr', '0000000000', 'CommunicationServices', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('jlallemant', 'LALLEMANT', 'Jean-Claude', 'jean-claude.lallemant@capgemini.com', '0000000000', 'CapGemini', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('nmarestin', 'MARESTIN', 'Nicolas', 'nicolas.marsetin@airbus.com', '0000000000', 'AirbusDS', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('clefebvre', 'LEFEBVRE', 'Charlotte', 'charlotte.lefebvre@airbus.com', '0000000000', 'AirbusDS', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('jbrutus', 'BRUTUS', 'Julien', 'julien.brutus@airbus.com', '0000000000', 'AirbusDS', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('sbrocard', 'BROCARD', 'Sébastien', 'sebastien.brocard@airbus.com', '0000000000', 'AirbusDS', TRUE);
INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer)
	VALUES('bsalery', 'SALERY', 'Benjamin', 'benjamin.salery@astrium.eads.fr', '0000000000', 'AirbusDS', TRUE);

-- PROJETS
INSERT INTO t_projet (id_user, project_name, project_num, is_destroyed) VALUES(009, 'AstroTerra','AST', FALSE);
INSERT INTO t_projet (id_user, project_name, project_num, is_destroyed) VALUES(005, 'Pléiades','PHR', FALSE);

-- LIVRABLES
INSERT INTO t_livrable (id_projet, liv_name, liv_num, nb_jours_ctu, nb_jours_aiv, cout_total, liv_type, date_liv, liv_version, liv_status, is_destroyed) 
	VALUES(001,'V03-02', '03-02', 0.0, 0.0, 0.0, 'VERSION', '2016-06-05', NULL, NULL, FALSE);
INSERT INTO t_livrable (id_projet, liv_name, liv_num, nb_jours_ctu, nb_jours_aiv, cout_total, liv_type, date_liv, liv_version, liv_status, is_destroyed) 
	VALUES(001,'V03-02-01', '03-02-01', 0.0, 0.0, 0.0, 'PATCH', '2016-06-07', NULL, NULL, FALSE);
INSERT INTO t_livrable (id_projet, liv_name, liv_num, nb_jours_ctu, nb_jours_aiv, cout_total, liv_type, date_liv, liv_version, liv_status, is_destroyed) 
	VALUES(001,'V04-02', '04-02', 0.0, 0.0, 0.0, 'VERSION', '2016-06-03', NULL, NULL, FALSE);
INSERT INTO t_livrable (id_projet, liv_name, liv_num, nb_jours_ctu, nb_jours_aiv, cout_total, liv_type, date_liv, liv_version, liv_status, is_destroyed) 
	VALUES(002,'V04-13', '04-13', 0.0, 0.0, 0.0, 'VERSION', '2016-06-17', NULL, NULL, FALSE);
INSERT INTO t_livrable (id_projet, liv_name, liv_num, nb_jours_ctu, nb_jours_aiv, cout_total, liv_type, date_liv, liv_version, liv_status, is_destroyed) 
	VALUES(002,'V04-12-30', '04-12-30', 0.0, 0.0, 0.0, 'PATCH', '2016-07-08', NULL, NULL, FALSE);

-- ACTIONS
INSERT INTO t_actions (id_userresp_ctu, id_userresp_aiv, action_name, action_num, description, collab_link, nb_jours_estime, nb_jours_ctu, nb_jours_aiv, price, document_link, action_analyse, action_response, id_user, action_status, is_destroyed) 
	VALUES(001, 001, 'Amélioration des fonctions AU de notification', 'PM 34894', NULL, NULL, 0.0, 8.5, 3.0, 13720.0, NULL, NULL, NULL, 002, NULL, FALSE);
INSERT INTO t_actions (id_userresp_ctu, id_userresp_aiv, action_name, action_num, description, collab_link, nb_jours_estime, nb_jours_ctu, nb_jours_aiv, price, document_link, action_analyse, action_response, id_user, action_status, is_destroyed) 
	VALUES(001, 001, 'Amélioration ergonomie diverses AU', 'PM 34896', NULL, NULL, 0.0, 12.0, 4.0, 19551.0, NULL, NULL, NULL, 002, NULL, FALSE);
INSERT INTO t_actions (id_userresp_ctu, id_userresp_aiv, action_name, action_num, description, collab_link, nb_jours_estime, nb_jours_ctu, nb_jours_aiv, price, document_link, action_analyse, action_response, id_user, action_status, is_destroyed) 
	VALUES(001, 001, 'Acceder au serveur multi-missions OCCAT', 'PM 33546', NULL, NULL, 0.0, 11.5, 4.5, 23524.0, NULL, NULL, NULL, 002, NULL, FALSE);
INSERT INTO t_actions (id_userresp_ctu, id_userresp_aiv, action_name, action_num, description, collab_link, nb_jours_estime, nb_jours_ctu, nb_jours_aiv, price, document_link, action_analyse, action_response, id_user, action_status, is_destroyed) 
	VALUES(001, 001, 'Optimisation des propagations de requêtes ICR / PR', 'PM 34514', NULL, NULL, 0.0, 2.5, 1.0, 5145.0, NULL, NULL, NULL, 002, NULL, FALSE);
INSERT INTO t_actions (id_userresp_ctu, id_userresp_aiv, action_name, action_num, description, collab_link, nb_jours_estime, nb_jours_ctu, nb_jours_aiv, price, document_link, action_analyse, action_response, id_user, action_status, is_destroyed) 
	VALUES(001, 001, 'Amélioration ergonomie diverses UAS', 'CR 483', NULL, NULL, 0.0, 11.0, 7.0, 19545.0, NULL, NULL, NULL, 002, NULL, FALSE);
INSERT INTO t_actions (id_userresp_ctu, id_userresp_aiv, action_name, action_num, description, collab_link, nb_jours_estime, nb_jours_ctu, nb_jours_aiv, price, document_link, action_analyse, action_response, id_user, action_status, is_destroyed) 
	VALUES(001, 001, 'Amélioration des fonctions UAS de notification', 'CR 484', NULL, NULL, 0.0, 5.5, 6.0, 9672.66, NULL, NULL, NULL, 002, NULL, FALSE);
INSERT INTO t_actions (id_userresp_ctu, id_userresp_aiv, action_name, action_num, description, collab_link, nb_jours_estime, nb_jours_ctu, nb_jours_aiv, price, document_link, action_analyse, action_response, id_user, action_status, is_destroyed) 
	VALUES(001, 001, 'Modification de la rétention des exports ICR', 'CR 485', NULL, NULL, 0.0, 1.0, 1.0, 1450.90, NULL, NULL, NULL, 002, NULL, FALSE);

