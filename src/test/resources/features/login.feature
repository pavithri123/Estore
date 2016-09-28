Feature: Login

@Reg
Scenario Outline:EES/Login/005, ES/Login/006, ES/Login/007
Given user direts to the VO click on login button "<url>"
And click on vo_option "<vo_option>"
When user enter valid beta_username "<username>" and valid beta_password "<pwd>"
And click on beta_Login button
And user directs to beta_vo
Then click on beta_Shop tab
Given directs to products page "<img>"

Examples:
|url|vo_option|username|pwd|img|
|http://www.qntest.com/|beta|hu041741|testpw|images/EN/navEN_01.jpg|
|http://www.qntest.com/|beta|HD329500|testpw|images/EN/navEN_01.jpg|
|http://www.qntest.com/|beta|CU000637|testpw|images/nav_adtlret01.jpg|

@Reg
Scenario Outline:EES/Login/009, ES/Login/0010, ES/Login/0011
Given user direts to the VO click on login button "<url>"
And click on vo_option "<vo_option>"
When user enter valid username "<username>" and valid password "<pwd>"
And click on direct shop
And click on Login button
Then directs to products page without vo "<img>"


Examples:
|url|vo_option|username|pwd|img|
|http://www.qntest.com/|current|hu041741|testpw|images/EN/navEN_01.jpg|
|http://www.qntest.com/|current|HD329500|testpw|images/EN/navEN_01.jpg|
|http://www.qntest.com/|current|CU000637|testpw|images/nav_adtlret01.jpg|

@Reg
Scenario Outline:ES/Login/004
Given user direts to the VO click on login button "<url>"
And click on vo_option "<vo_option>"
When user enter valid username "<username>" and valid password "<pwd>"
And click on Login button
And close the error msg

Examples:
|url|vo_option|username|pwd|
|http://www.qntest.com/|current|incpwd|testpw|

@Reg
Scenario Outline:ES/Login/008
Given user direts to the VO click on login button "<url>"
And click on vo_option "<vo_option>"
When user enter valid beta_username "<username>" and valid beta_password "<pwd>"
And click on beta_Login button
And check error msg

Examples:
|url|vo_option|username|pwd|
|http://www.qntest.com/|beta|incpwd|testpw|


@Reg
Scenario Outline:ES/Login/001, ES/Login/002, ES/Login/003
Given user direts to the VO click on login button "<url>"
And click on vo_option "<vo_option>"
When user enter valid username "<username>" and valid password "<pwd>"
And click on Login button
And user directs to vo "<ir_type>"
Then click on Shop tab
Given directs to products page "<img>"

Examples:
|url|vo_option|username|pwd|ir_type|img|
|http://www.qntest.com/|current|hu041741|testpw|qua_ir|images/EN/navEN_01.jpg|
|http://www.qntest.com/|current|HD329500|testpw|unqua_ir|images/EN/navEN_01.jpg|
|http://www.qntest.com/|current|CU000637|testpw|qua_rc|images/nav_adtlret01.jpg|





