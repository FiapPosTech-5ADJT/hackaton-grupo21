CREATE TABLE tipo_exame (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preparo_necessario TEXT,
    prazo_entrega INTEGER
);

CREATE TABLE solicitacao_exame (
    id SERIAL PRIMARY KEY,
    id_paciente VARCHAR(11) NOT NULL,  -- CPF do paciente
    id_profissional VARCHAR(11) NOT NULL,  -- CPF do profissional
    id_tipo_exame INTEGER REFERENCES tipo_exame(id),
    data_solicitacao TIMESTAMP DEFAULT NOW(),
    urgente BOOLEAN DEFAULT FALSE
);

CREATE TABLE agendamento_exame (
    id SERIAL PRIMARY KEY,
    id_solicitacao INTEGER REFERENCES solicitacao_exame(id),
    id_unidade_saude INTEGER,  -- Armazena apenas o ID (sem FOREIGN KEY)
    data_hora TIMESTAMP NOT NULL,
    status VARCHAR(20) DEFAULT 'pendente'
);

CREATE TABLE resultado_exame (
    id SERIAL PRIMARY KEY,
    id_agendamento INTEGER REFERENCES agendamento_exame(id),
    arquivo_resultado BYTEA,  -- Ou caminho para o arquivo no storage (ex: AWS S3)
    data_liberacao TIMESTAMP DEFAULT NOW(),
    observacoes TEXT
);

CREATE TABLE unidade_saude (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco TEXT,
    tipo VARCHAR(50),              -- Ex: "Hospital", "UBS", "Laboratório"
    cidade VARCHAR(50) NOT NULL,   -- Ex: "São Paulo"
    estado CHAR(2) NOT NULL,       -- Ex: "SP" (sigla de 2 caracteres)
    latitude DECIMAL(10, 8),       -- Opcional: para mapas
    longitude DECIMAL(11, 8)       -- Opcional: para mapas
);
-- Adicionando índices para melhorar o desempenho
CREATE INDEX idx_solicitacao_exame_id_paciente ON solicitacao_exame(id_paciente);
CREATE INDEX idx_solicitacao_exame_id_profissional ON solicitacao_exame(id_profissional);
CREATE INDEX idx_agendamento_exame_id_solicitacao ON agendamento_exame(id_solicitacao);
CREATE INDEX idx_resultado_exame_id_agendamento ON resultado_exame(id_agendamento);
