INSERT INTO events (imgId, eventName, description, genre, inicio, fim)
VALUES 
    (1, 'Concert 1', 'Amazing concert', 'SHOW', '2022-01-01 20:00:00', '2022-01-01 22:00:00'),
    (2, 'Concert 2', 'Awesome concert', 'SHOW', '2022-02-01 19:30:00', '2022-02-01 21:30:00'),
    (3, 'Concert 3', 'Incredible concert', 'SHOW', '2022-03-01 18:00:00', '2022-03-01 20:00:00');
       
INSERT INTO users (password, email, name, cpf, role, status)
VALUES
    ('teste', 'teste@teste', 'teste', '1111', 'USER', 'active'),
    ('password1', 'user1@example.com', 'User 1', '12345678901', 'USER', 'active'),
    ('password2', 'user2@example.com', 'User 2', '23456789012', 'USER', 'active'),
    ('password3', 'user3@example.com', 'User 3', '34567890123', 'USER', 'inactive');
