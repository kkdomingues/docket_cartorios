DROP TABLE IF EXISTS CARTORIO;
  
CREATE TABLE CARTORIO (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  certificates VARCHAR(250) DEFAULT NULL
);

INSERT INTO CARTORIO (name, address, certificates) VALUES
  ('Cartorio SP', 'Rua São Paulo, 123', '2ª Via de x'),
  ('Cartorio RJ', 'Rua foo bar, 456', '2ª Via de y'),
  ('Cartorio PR', 'Rua XPTO, 789', '2ª Via de z');