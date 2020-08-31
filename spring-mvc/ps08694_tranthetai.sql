use master
go
drop database ps08694_tranthetai
go
create database  ps08694_tranthetai
go
use  ps08694_tranthetai
go

create table Users
(
	username varchar(50) primary key,
	[password] varchar(20),
	fullname Nvarchar(50),
	img varchar(50)
)
go
create table Departments
(
	departId varchar(20) primary key,
	name Nvarchar(50),
	[status] bit
)
go
create table Staffs
(
	staffId int identity(1,1) primary key,
	staff_name Nvarchar(50),
	gender bit,
	birthday date,
	photo varchar(50),
	email varchar(50),
	salary float,
	notes Nvarchar(50),
	departId varchar(20) references Departments(DepartId),
	deleted bit
	
)
go
create table Records
(
	recordId int identity(1,1) primary key,
	record_type bit,
	record_date date,
	reason nvarchar(200),
	staffId int references Staffs(StaffId)
)
go
--2. thêm dữ liệu vào
--Bước 1 thêm bảng User, Depart
--Bước 2 Staff
--Bước 3 Record


insert into Users values('phuc','123456',N'Cao Hoàng Phúc','student.png')
go
insert into Users values('thanh','123456',N'Nguyễn Quang Thành','student.png')
go
insert into Users values('loc','123456',N'Thành Lộc','student.png')
go
insert into Users values('cuong','123456',N'Phạm Thanh Cường','student.png')
go
insert into Users values('vu','123456',N'Lê Minh Vũ','student.png')
go


insert into Departments values('DP01',N'Nhân sự', 0)
go			
insert into Departments values('DP02',N'Sales', 0)
go			
insert into Departments values('DP03',N'Kho', 0)
go		
insert into Departments values('DP04',N'Thiết kế', 0)
go		
insert into Departments values('DP05',N'Kinh doanh', 0)
go



insert into Staffs values(N'Nguyễn Minh Thành',1,convert(date, '11/10/1995', 103),'thanh.jpg','thanh@fpt.edu.vn',10000000,'','DP01',0)
go
insert into Staffs values(N'Cao Phúc Lộc',0,convert(date, '15/10/1995', 103),'loc.jpg','loc@fpt.edu.vn',20000000,'','DP01',0)
go
insert into Staffs values(N'Lê Cương', 1,convert(date, '1/8/1995', 103),'cuong.jpg','cuong@fpt.edu.vn',200000,'','DP02',0)
go
insert into Staffs values(N'Lê Minh Vũ',1,convert(date, '3/7/1997', 103),'vu.jpg','vu@fpt.edu.vn',7000000,'','DP02',0)
go
insert into Staffs values(N'Hạ Tuyết Kỳ',1,convert(date, '12/3/1995', 103),'ky.jpg','ky@fpt.edu.vn',6000000,'','DP03',0)
go
insert into Staffs values(N'Nguyễn Cao Đông Quân',0,convert(date, '16/12/1995', 103),'dong.jpg','dong@fpt.edu.vn',4000000,'','DP03',0)
go
insert into Staffs values(N'Trần Bình Trọng',1,convert(date, '4/10/1995', 103),'trong.jpg','trong@fpt.edu.vn',15000000,'','DP04',0)
go
insert into Staffs values(N'Trần Tình',1,convert(date, '17/6/1995', 103),'tinh.jpg','tinh@fpt.edu.vn',1400000,'','DP04',0)
go
insert into Staffs values(N'La Minh Hùng',1,convert(date, '21/10/1995', 103),'hung.jpg','hung@fpt.edu.vn',21000000,'','DP05',0)
go
insert into Staffs values(N'Bảo',1,convert(date, '22/2/1995', 103),'bao.jpg','bao@fpt.edu.vn',20000000,'','DP05',0)
go


insert into Records values(1,convert(date, '6/12/2019', 103), N'Đi làm trễ 30 phút',1)
go
insert into Records values(0,convert(date, '5/12/2019', 103), N'Hoàn thành công việc xuất sắc',2)
go
insert into Records values(1,convert(date, '4/12/2019', 103), N'Đi làm trễ 30 phút',3)
go
insert into Records values(1,convert(date, '3/12/2019', 103), N'Đi làm trễ 30 phút',4)
go															  
insert into Records values(1,convert(date, '2/12/2019', 103), N'Đi làm trễ 30 phút',5)
go															  
insert into Records values(0,convert(date, '1/12/2019', 103), N'Không nghỉ phép ngày nào',6)
go															  
insert into Records values(1,convert(date, '1/12/2019', 103), N'Nghỉ 2 ngày không báo trước',7)
go															  
insert into Records values(1,convert(date, '2/12/2019', 103), N'Không hoàn thành công việc được giao',8)
go															  
insert into Records values(1,convert(date, '2/12/2019', 103), N'Không hoàn thành công việc được giao',9)
go															  
insert into Records values(1,convert(date, '2/12/2019', 103), N'Không hoàn thành công việc được giao',10)
go


select * from records where record_type = 'true'; 