--���¼�
select jgbh,jgjc��jgjb,
connect_by_root(jgbh),--��ø��ڵ�
connect_by_isleaf --�Ƿ���Ҷ�ڵ�
 from tb_jg a
start with jgbh = '00003500'
connect by prior jgbh= sjjg

--���ϼ�
select decode(length(jgbh),8,jgbh,10,substr(jgbh,0,8)) jgbh,jgjc,jgjb,connect_by_isleaf from tb_jg a
start with jgbh = '01002044'
connect by jgbh=prior sjjg

select * from tb_jg where jgbh = '0100204400'

update tb_jg set jgbh = '01002044' where jgbh = '0100204400'
