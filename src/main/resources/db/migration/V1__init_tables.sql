CREATE TABLE KANTOR (
  id SERIAL PRIMARY KEY,
  nama_kantor VARCHAR(255) NOT NULL,
  kode_kantor VARCHAR(10) NOT NULL UNIQUE,
  alamat_kantor TEXT,
  waktu_rekam TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  waktu_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE GUDANG (
  id SERIAL PRIMARY KEY,
  kode_gudang VARCHAR(10) NOT NULL,
  kode_kantor VARCHAR(10) NOT NULL,
  alamat TEXT,
  latitude DECIMAL(10, 8),
  longitude DECIMAL(11, 8),
  waktu_rekam TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  waktu_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_gudang UNIQUE (kode_gudang, kode_kantor),
  CONSTRAINT fk_gudang_kantor FOREIGN KEY (kode_kantor)
    REFERENCES KANTOR (kode_kantor)
);

CREATE TABLE KONTAINER (
  id SERIAL PRIMARY KEY,
  kode_gudang VARCHAR(10) NOT NULL,
  kode_kantor VARCHAR(10) NOT NULL,
  nomor_kontainer VARCHAR(17) NOT NULL,
  ukuran_kontainer VARCHAR(5),
  tanggal_tiba DATE NOT NULL,
  bruto DECIMAL(10, 3),
  waktu_rekam TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  nomor_dokumen VARCHAR(50),
  CONSTRAINT fk_kontainer_gudang FOREIGN KEY (kode_gudang, kode_kantor)
    REFERENCES GUDANG (kode_gudang, kode_kantor)
);
