create database if not exists laptopdb;
use laptopdb;
create table laptop(
	`l_id` int(11) not null auto_increment unique,
    `l_model` varchar(45) not null default '',
    `manufacturer` VARCHAR(45) NOT NULL DEFAULT 'Clevo', 
    `screen_size` DECIMAL(3,1) NOT NULL DEFAULT 15.6,
	`screen_resolution` VARCHAR(45) NOT NULL DEFAULT '1920x1080' ,
	`kb_backlight` ENUM('monochrome', 'color', 'none') NOT NULL DEFAULT 'none' ,
	`cpu` VARCHAR(45) NOT NULL DEFAULT 'Core i7 4700MQ' ,
	`gpu` VARCHAR(45) NULL DEFAULT NULL ,
	`main_mem` SMALLINT(3) NOT NULL DEFAULT 4 ,
	`video_mem` DOUBLE ,
	`storage_type` ENUM('HDD', 'SSD') NOT NULL DEFAULT 'HDD' ,
	`storage_size` SMALLINT(4) NOT NULL DEFAULT 500 ,
	`adapter_power` SMALLINT(3) NOT NULL DEFAULT 150,
	`weight` DOUBLE NOT NULL DEFAULT 0 ,
    primary key (l_id)
    );