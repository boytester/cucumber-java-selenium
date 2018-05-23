Feature: 这是一个测试样本  
  
  
  Scenario: 用户登录
    Given 用户打开jgcrm登录界面
      And 输入用户账号"admin"和密码"123456"
     When 点击登录按钮
     Then 登录成功