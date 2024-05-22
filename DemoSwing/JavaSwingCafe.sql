CREATE DATABASE IF NOT EXISTS cafe 
DEFAULT CHARACTER SET utf8mb4 
DEFAULT COLLATE utf8mb4_unicode_ci;

USE cafe;

DROP TABLE IF EXISTS quanli;
CREATE TABLE quanli (
    tenkhachhang VARCHAR(40),
    ban VARCHAR(20) NOT NULL,
    sodienthoai VARCHAR(14),
    monandouong VARCHAR(50) NOT NULL,
    soluong INT NOT NULL,
    gia DOUBLE NOT NULL,
    ngay VARCHAR(20)
);

DROP TABLE IF EXISTS taikhoan;
CREATE TABLE taikhoan (
	tentaikhoan varchar(50) not null,
    matkhau varchar(30) not null
);
