CREATE TABLE [dbo].[city](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NULL,
	[state] [varchar](100) NULL,
	[country] [varchar](100) NULL,
 CONSTRAINT [PK__city__3213E83F483E6691] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON, FILLFACTOR = 80) ON [PRIMARY]
) ON [PRIMARY]

INSERT INTO city (name, state, country) VALUES ('San Francisco', 'CA', 'US');

use Accjiaowu
select * from qz_question where questionID=11122945
select * from qz_question_option where questionID=11122945
select * from QZ_QUESTION_VIDEO where questionID=11122945

select * from city
