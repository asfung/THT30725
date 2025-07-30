INSERT INTO KANTOR (nama_kantor, kode_kantor, alamat_kantor)
VALUES 
('Kantor Pusat Jakarta', 'KTR-JKT', 'Jl. Merdeka No.1, Jakarta'),
('Kantor Surabaya', 'KTR-SBY', 'Jl. Tunjungan No.10, Surabaya'),
('Kantor Medan', 'KTR-MDN', 'Jl. Gatot Subroto No.20, Medan');

INSERT INTO GUDANG (kode_gudang, kode_kantor, alamat, latitude, longitude)
VALUES 
('GDG-JKT-01', 'KTR-JKT', 'Gudang 1 Jakarta', -6.200000, 106.816666),
('GDG-SBY-01', 'KTR-SBY', 'Gudang 1 Surabaya', -7.250445, 112.768845),
('GDG-MDN-01', 'KTR-MDN', 'Gudang 1 Medan', 3.595196, 98.672223),
('GDG-JKT-02', 'KTR-JKT', 'Gudang 2 Jakarta', -6.201111, 106.817222);

INSERT INTO KONTAINER (kode_gudang, kode_kantor, nomor_kontainer, ukuran_kontainer, tanggal_tiba, bruto, nomor_dokumen)
VALUES 
('GDG-JKT-01', 'KTR-JKT', 'CONT-JKT-0001', '20FT', '2024-06-10', 1250.500, 'DOC-JKT-001'),
('GDG-JKT-02', 'KTR-JKT', 'CONT-JKT-0002', '40FT', '2024-06-11', 2300.000, 'DOC-JKT-002'),
('GDG-SBY-01', 'KTR-SBY', 'CONT-SBY-0001', '20GP', '2024-06-12', 1500.250, 'DOC-SBY-001'),
('GDG-MDN-01', 'KTR-MDN', 'CONT-MDN-0001', '20FT', '2024-06-13', 1200.750, 'DOC-MDN-001'),
('GDG-MDN-01', 'KTR-MDN', 'CONT-MDN-0002', '40FT', '2024-06-14', 2700.100, 'DOC-MDN-002');
