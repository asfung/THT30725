INSERT INTO KANTOR (nama_kantor, kode_kantor, alamat_kantor)
VALUES 
('Kantor Bali', 'SBY01', 'Jalan Diponegoro'),
('Kantor Jakarta', 'JKT01', 'Jalan Raya Casablanca'),
('Kantor Bandung', 'BDG01', 'Jalan Siliwangi'),
('Kantor Tangerang', 'TGG01', 'Jalan Kota Tangerang'),
('Kantor Makassar', 'MKS01', 'Jalan Kakatua'),
('Kantor Semarang', 'SRG01', 'Jalan Atmodirono');


INSERT INTO GUDANG (kode_gudang, kode_kantor, alamat, latitude, longitude)
VALUES 
('GDG-JKT01', 'JKT01', 'Gudang01 Jakarta', -8.834029, 123.830273),
('GDG-SBY01', 'SBY01', 'Gudang01 Surabaya', -2.3872, 82.839347),
('GDG-BDG01', 'BDG01', 'Gudang01 Bandung', 99.839322, 9.432892),
('GDG-TGG01', 'TGG01', 'Gudang01 Tangerang', 29.839322, 22.8432432),
('GDG-MKS01', 'MKS01', 'Gudang01 Makassar', 3.348989, 43.7874354),
('GDG-SRG01', 'SRG01', 'Gudang01 Semarang', 39.839322, 93.8432432),
('GDG-JKT02', 'JKT01', 'Gudang02 Jakarta', -6.783289, 199.743933);

INSERT INTO KONTAINER (kode_gudang, kode_kantor, nomor_kontainer, ukuran_kontainer, tanggal_tiba, bruto, nomor_dokumen)
VALUES 
('GDG-JKT01', 'JKT01', 'CONT-JKT-0001', '29FT', '2024-02-10', 10.000, 'DOC-JKT-01'),
('GDG-JKT02', 'JKT01', 'CONT-JKT-0002', '80FT', '2025-04-11', 200.000, 'DOC-JKT-02'),
('GDG-SBY01', 'SBY01', 'CONT-SBY-0001', '5GP', '2024-04-12', 199.000, 'DOC-SBY-01'),
('GDG-BDG01', 'BDG01', 'CONT-BDG-0001', '50FT', '2024-02-13', 800.888, 'DOC-BDG-01'),
('GDG-BDG01', 'BDG01', 'CONT-BDG-0002', '22FT', '2024-02-14', 2400.100, 'DOC-BDG-01');
