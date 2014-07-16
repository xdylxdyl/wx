import sys
default_encoding = 'UTF-8'
if sys.getdefaultencoding() != default_encoding:
    reload(sys)
    sys.setdefaultencoding(default_encoding)

import MySQLdb
import datetime
import smtplib  
from email.mime.text import MIMEText

mailto_list=["hechengcai@qding.me"]
mail_host="smtp.163.com"
mail_user="qdnotify"
mail_pass="1qaz2wsx"
mail_postfix="163.com"

def send_mail(to_list,sub,content):  
    me="<"+mail_user+"@"+mail_postfix+">"  
    msg = MIMEText(content,_subtype='html',_charset='GB2312')  
    msg['Subject'] = sub  
    msg['From'] = me  
    msg['To'] = ";".join(to_list)  
    try:  
        server = smtplib.SMTP()  
        server.connect(mail_host)  
        server.login(mail_user,mail_pass)  
        server.sendmail(me, to_list, msg.as_string())  
        server.close()  
        return True  
    except Exception, e:  
        print str(e)
        return False

lastDate = datetime.date.today() - datetime.timedelta(days=1)
emailTitle = "千丁互联微信团购日报: %s " % lastDate.strftime('%Y%m%d')
emailContent = ""

COMMUNITY_DB_NAME = "community_framework"
DB_NAME = "framework_user"
ORDER_DB_NAME = "app_goods"
DB_USER = "root"
DB_PWD = "123456"
DB_HOST = "42.96.145.106"

publics={}
# query publics
sql = "select id, name from publics order by id"
db = MySQLdb.connect(host=DB_HOST,user=DB_USER,passwd=DB_PWD,db=COMMUNITY_DB_NAME,charset="UTF8")
cursor = db.cursor()
try:
	cursor.execute(sql)
	publics_results = cursor.fetchall()
	for row in publics_results:
		publicId = row[0]
		publicName = row[1]
		publics[publicId] = publicName
except:
	print "Error: unable to fecth data"



potential_daily={}
# query potential daily
sql = "select count(*) as potentialCount, publics_id from potential where status = 0 and FROM_UNIXTIME(create_at/1000, '%Y%m%d') = date_format(date_sub(now(), INTERVAL 3 HOUR), '%Y%m%d') group by publics_id"
db = MySQLdb.connect(host=DB_HOST,user=DB_USER,passwd=DB_PWD,db=DB_NAME,charset="UTF8")
cursor = db.cursor()
try:
	cursor.execute(sql)
	potential_daily_results = cursor.fetchall()
	for row in potential_daily_results:
		potentialCount = row[0]
		publics_id = row[1]
		potential_daily[publics_id] = potentialCount
except:
	print "Error: unable to fecth data"


potential_all={}
# query potential all
sql = "select count(*) as potentialCount, publics_id from potential where status = 0 and FROM_UNIXTIME(create_at/1000, '%Y%m%d') <= date_format(date_sub(now(), INTERVAL 3 HOUR), '%Y%m%d') group by publics_id"
db = MySQLdb.connect(host=DB_HOST,user=DB_USER,passwd=DB_PWD,db=DB_NAME,charset="UTF8")
cursor = db.cursor()
try:
	cursor.execute(sql)
	potential_all_results = cursor.fetchall()
	for row in potential_all_results:
		potentialCount = row[0]
		publics_id = row[1]
		potential_all[publics_id] = potentialCount
except:
	print "Error: unable to fecth data"

potential_unsubscribe={}
# query potential unsubscribe
sql = "select count(*) as potentialCount, publics_id from potential where status = 1 and FROM_UNIXTIME(unsubscribe_at/1000, '%Y%m%d') = date_format(date_sub(now(), INTERVAL 3 HOUR), '%Y%m%d') group by publics_id"
db = MySQLdb.connect(host=DB_HOST,user=DB_USER,passwd=DB_PWD,db=DB_NAME,charset="UTF8")
cursor = db.cursor()
try:
	cursor.execute(sql)
	potential_unsubscribe_results = cursor.fetchall()
	for row in potential_unsubscribe_results:
		potentialCount = row[0]
		publics_id = row[1]
		potential_unsubscribe[publics_id] = potentialCount
except:
	print "Error: unable to fecth data"

# query user 注册用户
db = MySQLdb.connect(host=DB_HOST,user=DB_USER,passwd=DB_PWD,db=DB_NAME,charset="UTF8")
cursor = db.cursor()
sql = "select count(*) as userCount from user where FROM_UNIXTIME(create_at/1000, '%Y%m%d') = date_format(date_sub(now(), INTERVAL 3 HOUR), '%Y%m%d')"
try:
	cursor.execute(sql)
	userCount = cursor.fetchone()
	print "userCount : %s " % userCount
	emailContent = "注册用户: %s " % userCount
except:
	print "Error: unable to fecth data"


# potential 关注用户
potential_daily_count = 0
potential_all_count = 0
potential_unsubscribe_count = 0
emailContent = emailContent + "<br/>关注用户: "
for key in publics:
	potentialDaily = 0
	if type(potential_daily.get(key)) != type(None):
		potentialDaily = potential_daily.get(key)
	potential_daily_count += potentialDaily
	
	potentialAll = 0
	if type(potential_all.get(key)) != type(None):
		potentialAll = potential_all.get(key)
	potential_all_count += potentialAll
	
	potentialUnsubscribe = 0
	if type(potential_unsubscribe.get(key)) != type(None):
		potentialUnsubscribe = potential_unsubscribe.get(key)
	potential_unsubscribe_count += potentialUnsubscribe
	
	print 'key=%s, value=%s, potential_daily=%s, potential_all=%s, potential_unsubscribe=%s' % (key, publics[key], potentialDaily, potentialAll, potentialUnsubscribe)
	emailContent = emailContent + "<br/>公众号  : %s, 本日新增 : %s,  截止本日累计 : %s, 本日取消关注 : %s" % (publics[key], potentialDaily, potentialAll, potentialUnsubscribe)
emailContent = emailContent + "<br/>合计：共管辖公众号： %s个, 本日新增 : %s,  截止本日累计 : %s, 本日取消关注 : %s" % (len(publics), potential_daily_count, potential_all_count, potential_unsubscribe_count)
		
# query order
db = MySQLdb.connect(host=DB_HOST,user=DB_USER,passwd=DB_PWD,db=ORDER_DB_NAME,charset="UTF8")
cursor = db.cursor()
sql = "select count(*) as orderCount, sum(total) as totalSum, publics_id, type from gorder where FROM_UNIXTIME(create_at/1000, '%Y%m%d') = date_format(date_sub(now(), INTERVAL 3 HOUR), '%Y%m%d') group by publics_id, type order by publics_id desc, type desc, orderCount desc"
allOrderCount = 0
allTotalSum = 0
try:
	cursor.execute(sql)
	results = cursor.fetchall()
	emailContent = emailContent + "<br/>订单: "
	for row in results:
		orderCount = row[0]
		totalSum = row[1]
		type = row[3]
		publics_id = row[2]
		publicName = publics[publics_id]
		allOrderCount += orderCount
		allTotalSum += totalSum
		print "orderCount : %s,totalSum : %d,type : %s,publicName : %s" % (orderCount, totalSum, type, publicName)
		emailContent = emailContent + "<br/>公众号  : %s, 订单类型 : %s,订单数 : %s, 总金额 : %d"  % (publicName, type, orderCount, totalSum)
	emailContent = emailContent + "<br/>总计:  订单数 : %s, 总金额 : %d"  % (allOrderCount, allTotalSum)
	
	# 已付全款
	sql = "select sum(total) from gorder where status = 4 and FROM_UNIXTIME(update_at/1000, '%Y%m%d') = date_format(date_sub(now(), INTERVAL 3 HOUR), '%Y%m%d')"
	cursor.execute(sql)
	row = cursor.fetchone()
	if row is not None:
		data1 = row[0]
		if data1 is None:
			data1 = 0
	else:
		data1 = 0
	
	# 待付款
	sql = "select sum(total) from gorder where status = 1 and FROM_UNIXTIME(create_at/1000, '%Y%m%d') = date_format(date_sub(now(), INTERVAL 3 HOUR), '%Y%m%d')"
	cursor.execute(sql)
	row = cursor.fetchone()
	if row is not None:
		data2 = row[0]
		if data2 is None:
			data2 = 0
	else:
		data2 = 0
	emailContent = emailContent + "<br/>今日已付全款 : %d, 今日待付款 : %d"  % (data1, data2)
except:
	print "Error: unable to fecth data"
db.close()
#print "emailTitle : %s " % emailTitle
#print "emailContent : %s " % emailContent
if send_mail(mailto_list, emailTitle, emailContent):  
    print "success"
else:
    print "fail"
