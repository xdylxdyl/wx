//--------------editor
var userDetailModule = angular.module("userDetailApp", []);
userDetailModule.controller('userDetailController', function ($scope, $http, $sce, $timeout) {
 
    $scope.sexlist = [{
            sex: 'male',
            name: '先生'
    },
        {
            sex: 'female',
            name: '女士'
    },
    ];
    $scope.user = {};
    $scope.user.sex = "male";
    $scope.address = {};
    $scope.address.id;
    $scope.addresslist = {};
 
    var mobilereg = /^0?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$/;
    var mark = $("#id").val();
    $scope.verifyCode = "";
    $scope.wait = 60; //停留时间
    $scope.buttonvalue = "发送验证码";
 
    $scope.showsendcode = true;
    $scope.showcommit = true;
    $scope.showspanaddress = true;
    $scope.showinputname = true;
    $scope.showinputmobile = true;
    $scope.showform = false;    
    $scope.addressname = $scope.user.name;
 
    //初始化数据
    //bootbox.alert(mark);
    //界面元素初始化Start
    //界面元素初始化End
    if (mark > 0) {
        $http({
            method: 'GET',
            url: '/p/u/a/user/' + mark
        }).success(function (data, status) {
            if (status == '200') {
                console.log("data is");
                console.log(data.data);
                $scope.user = data.data;

                $scope.showform = true; 
            }
        });
 
        $http({
            method: 'GET',
            url: '/p/u/a/address?pageNo=1&pageSize=10'
 
        }).success(function (data, status) {
            if (status == '200') {
                console.log("data is");
                console.log(data.data);
                $scope.addresslist = data.data;
                $scope.address.id = data.data[0].id;
                $scope.address = data.data[0];
            }
        });
    } else
    	{

        $scope.showform = true; 
    	}
    
    
    if (mark > 0) {
        $scope.showsendcode = false;
        $scope.showcommit = false;
        $scope.showspanaddress = false;
        $scope.showinputname = false;
        $scope.showinputmobile = false;
        $scope.showaddressedit = false;
    }
 
    //点击编辑按钮
    $scope.editUser = function () {
        $scope.verifyCode = "";
        $scope.showcommit = true;
        $scope.showspanaddress = true;
        $scope.showinputname = true;
        $scope.showaddressedit = true;
        userForm.name.focus();
    };
 

 
    // 处理后台收不到数据的问题
    $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
    $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    $http.defaults.transformRequest = [function (data) {
            return $.param(data);
    }];
 
    //发送验证码
    $scope.sendCode = function () {
        if ($scope.userForm.mobile.$error.required) {
         	$("body").dialogs({
    			html : "<div class=\"msg\">手机号码不能为空!</div>",
    			width : "80%",
    			title : "温馨提示"
    		});
            
            
            //userForm.mobile.focus();
            return false;
        }
        if ($scope.user.mobile.length != 11) {
            
         	$("body").dialogs({
    			html : "<div class=\"msg\">手机号码长度不是11位!</div>",
    			width : "80%",
    			title : "温馨提示"
    		});
            
            
            //userForm.mobile.focus();
            return false;
        } else {
 
            if (!mobilereg.test($scope.user.mobile.trim())) {
            	
            	 
             	$("body").dialogs({
        			html : "<div class=\"msg\">请输入有效的手机号码!</div>",
        			width : "80%",
        			title : "温馨提示"
        		});
            	
                //userForm.mobile.focus();
                return false;
            }
        }
        console.log($scope.user.mobile);
        //return false;
        //倒计时效果Start 
        $("#sendcode").attr('disabled', "true");
        $scope.fight();
        //倒计时效果End
        //return false;
 
        $http({
            method: 'POST',
            url: '/a/send/sms?mobile=' + $scope.user.mobile.trim() + "&type=regist",
            data: {},
        }).success(function (data) {
            console.log(data);
            if (data.code==0) {
            	

             	$("body").dialogs({
        			html : "<div class=\"msg\">已将验证码通过短信发送至您的手机。有效时长60秒!</div>",
        			width : "80%",
        			title : "温馨提示"
        		});
            	
            } else {

             	$("body").dialogs({
        			html : "<div class=\"msg\">短信发送失败!</div>",
        			width : "80%",
        			title : "温馨提示"
        		});
            }
        });
 
    };
 
    //
    var stop;
    $scope.fight = function () {
        stop = $timeout(function () {
            if ($scope.wait > 0) {
                $scope.buttonvalue = $scope.wait + "s后重新获取";
                $scope.wait = $scope.wait - 1;
                //console.log($scope.buttonvalue);
                $scope.fight();
            } else {
                $scope.buttonvalue = "发送验证码";
                $scope.wait = 60;
                $("#sendcode").removeAttr("disabled");
                $timeout.cancel(stop);
            }
        },
            1000);
    };
 
    //提交 新注册信息或编辑的信息               
    $scope.updateuser = function (user) {
        //验证表单S
        console.log("mark is");
        console.log(mark);
        if (mark > 0) {
            if (!$scope.formNameValid()) {
                return false;
            };
        } else {
            if ((!$scope.formMobileValid()) || (!$scope.formNameValid())) {
                return false;
            };
        };
        //验证表单E
        //add
        console.log("user commit is :");
        console.log(user);
        if (user.id == null) {
            console.log('add');
            $scope.user.verifyCode = $scope.verifyCode;
            $http({
                method: 'POST',
                url: '/p/a/user',
                data: user
            }).success(function (data, status) {
                console.log(data);
                if (status == '200') {
            	if(data.code == "0")
            		{

                 	$("body").dialogs({
            			html : "<div class=\"msg\">注册成功!</div>",
            			width : "80%",
            			title : "温馨提示"
            		});
            		
            		  location.href = data.url;
            		}else
            			{
                     	$("body").dialogs({
                			html : "<div class=\"msg\">注册失败!</div>",
                			width : "80%",
                			title : "温馨提示"
                		});
            			}
            }
            });
            //update 
        } else {
            console.log('update');
            $http({
                method: 'POST',
                url: '/p/u/a/user/' + $scope.user.id,
                data: user
            }).success(function (data, status) {
                console.log(data);
                if (status == '200') {
                        if (data.code == 0) {
                            location.href = "/p/u/user";
                        }
                }
            });
 
            //更新address
            $scope.address.name = $scope.user.name;
            $scope.address.sex = $scope.user.sex;
            $scope.address.phone = $scope.user.mobile;
            console.log($scope.address);
            $http({
                method: 'POST',
                url: '/p/u/a/address/' + $scope.address.id,
                data: $scope.address
            }).success(function (data, status) {
                if (status == '200') {
                    location.href = "/p/u/user";
                }
            });
        }
 
    };
    //页面验证-Start
    $scope.formNameValid = function () {
        if ($scope.userForm.name.$error.required) {

         	$("body").dialogs({
    			html : "<div class=\"msg\">姓名不能为空!</div>",
    			width : "80%",
    			title : "温馨提示"
    		});
            //userForm.name.focus();
            return false;
 
        }
        if ($scope.userForm.name.$error.maxlength) {
        	$("body").dialogs({
    			html : "<div class=\"msg\">长度不超过12!</div>",
    			width : "80%",
    			title : "温馨提示"
    		});
            //userForm.name.focus();
            return false;
        }
        return true;
    };
    $scope.formMobileValid = function () {
        if ($scope.userForm.mobile.$error.required) {
            $("body").dialogs({
    			html : "<div class=\"msg\">手机号码不能为空!</div>",
    			width : "80%",
    			title : "温馨提示"
    		});
            //userForm.mobile.focus();
            return false;
        }
        if ($scope.user.mobile.length != 11) {
            $("body").dialogs({
    			html : "<div class=\"msg\">手机号码长度不满足11位!</div>",
    			width : "80%",
    			title : "温馨提示"
    		});
            //userForm.mobile.focus();
            return false;
        } else {
            if (!mobilereg.test($scope.user.mobile.trim())) {
                $("body").dialogs({
        			html : "<div class=\"msg\">请输入有效的手机号码!</div>",
        			width : "80%",
        			title : "温馨提示"
        		});
                //userForm.mobile.focus();
                return false;
            }
        }
 
        if ($scope.userForm.verifyCode.$error.required) {
            $("body").dialogs({
    			html : "<div class=\"msg\">验证码不能为空!</div>",
    			width : "80%",
    			title : "温馨提示"
    		});
            //userForm.verifyCode.focus();
            return false;
        }
        if ($scope.userForm.verifyCode.$error.maxlength) {
            $("body").dialogs({
    			html : "<div class=\"msg\">长度不超过4!</div>",
    			width : "80%",
    			title : "温馨提示"
    		});
            //userForm.verifyCode.focus();
            return false;
        }
 
        /* console.log($scope.userForm);
        if ($scope.userForm.$invalid) {
            $scope.userForm.submitted = true;
        } else {};*/
        return true;
 
    };
    //页面验证-End 
});

userDetailModule.filter("sexname",function(){
	return function(input)
	{
		switch (input)
		{
		case "male":return "先生" ;break;
		case "female":return "女士" ;break;		
		}
		
	};
	 
	 
});
