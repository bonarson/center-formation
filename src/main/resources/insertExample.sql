-- Insertion dans la table training_center
INSERT INTO training_center (name, address, contact_details, equipment) VALUES
('Centre de Formation A', '123 Rue Principale', 'contact@centreA.com, +123456789', 'Projecteurs, Ordinateurs, Tableaux interactifs'),
('Centre de Formation B', '456 Avenue des Champs', 'contact@centreB.com, +987654321', 'Laboratoires, Salles de conférence, Bibliothèque');

-- Insertion dans la table class_session
INSERT INTO class_session (date_session, hour, subject, idTeacher) VALUES
('2024-08-01', '10:00', 'Mathématiques', 'T001'),
('2024-08-02', '14:00', 'Physique', 'T002');

-- Insertion dans la table course
INSERT INTO course (title, description, price, schedules, id_training_center, id_class_session) VALUES
('Cours de Mathématiques', 'Cours avancé de mathématiques couvrant divers sujets.', 150.0, 'Lundi et Mercredi, 10:00 - 12:00', 1, 1),
('Cours de Physique', 'Cours sur les principes fondamentaux de la physique.', 200.0, 'Mardi et Jeudi, 14:00 - 16:00', 2, 2);

-- Insertion dans la table registration
INSERT INTO registration ( status, id_user, id_course) VALUES
(DEFAULT, 'En cours', 'U001', 2),
(DEFAULT, 'Terminé', 'U002', 3);

-- Insertion dans la table wave
INSERT INTO wave (id_course, start_date, end_date) VALUES
(1, '2024-08-01', '2024-12-01'),
(2, '2024-09-01', '2024-12-15');
