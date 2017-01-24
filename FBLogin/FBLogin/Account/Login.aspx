<%@ Page Title="登入" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="FBLogin.Account.Login" Async="true" %>

<%@ Register Src="~/Account/OpenAuthProviders.ascx" TagPrefix="uc" TagName="OpenAuthProviders" %>



<asp:Content runat="server" ID="BodyContent" ContentPlaceHolderID="MainContent">
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId: '426711567719454',
            status: true, // check the login status upon init?
            cookie: true, // set sessions cookies to allow your server to access 
            xfbml: true,
            version: 'v2.8'
        });
    };

    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) { return; }
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    } (document, 'script', 'facebook-jssdk'));

    // This is called with the results from from FB.getLoginStatus().
    function statusChangeCallback(response) {
        // The response object is returned with a status field that lets the
        // app know the current login status of the person.
        // Full docs on the response object can be found in the documentation
        // for FB.getLoginStatus().
        if (response.status === 'connected') {
            // Logged into your app and Facebook.
            testAPI();
        } else if (response.status === 'not_authorized') {
            // The person is logged into Facebook, but not your app.
            document.getElementById('status').innerHTML = 'Please log ' +
            'into this app.';
        } else {
            // The person is not logged into Facebook, so we're not sure if
            // they are logged into this app or not.
            document.getElementById('status').innerHTML = 'Please log ' +
            'into Facebook.';
        }
    }

    // This function is called when someone finishes with the Login
    // Button.  See the onlogin handler attached to it in the sample
    // code below.
    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    }

    // Here we run a very simple test of the Graph API after login is
    // successful.  See statusChangeCallback() for when this call is made.
    function testAPI() {
        FB.api('/me', function(response) {
            document.getElementById('status').innerHTML = "FB user name : " + response.name + " 成功登入";
            ShowTaoble(response);
        });

    }
    
    // 用表單的方式顯示 Facebook response 回來的資料。
    function ShowTaoble(response) {
        var html = loopValue(response);
        document.getElementById("info").innerHTML = html;
    }

    // 取得 response Key and Value 迴圈
    function loopValue(response) {

        if (typeof response === 'string') { return response; }
        var html = "<table width='100%' style='word-break:break-all'>";

        for (var key in response) {
      
            html += (
              '<tr>' +
              '<th width = "100">' + key + '</th>' +
              '<td>' + response[key] + '</td>' +
              '</tr>'
            );
         

            if (typeof response[key] == "object") {
                html += "<tr><th>-</th><td>" + loopValue(response[key]) + "</td></tr>";
            }
            
            if (key == "accessToken") {
                document.getElementById("accessToken").value = response[key];
            }     

        }
        html += "</table>";

        return html;
    }

    function Logout() {
        FB.logout(function (response) {
            // user is now logged out
            alert('已成功登出!');
            window.location.reload();
        });
    }
    //設定 FB 登入 function
    //FB.login( callback( response ),{ scope: perms } );

    function loginFB() {
        // perms(string): 使用者同意之權限。
        var perms =
        'email,user_birthday,user_about_me,user_friends';//+
       // 'publish_stream,user_events,create_event,friends_events,' +
       // 'user_photos,friends_photos,user_photo_video_tags,friends_photo_video_tags';

        // FB JavaScript login function
        FB.login(function (response) {
            // API 回傳 response 值
            ShowTaoble(response);
            var accessToken = document.getElementById("accessToken").value;
            $.ajax({
                url: '../FacebookLogin.ashx',
                data: { accessToken: accessToken }, //不需要經過$.toJSON
                type: 'POST',
                success: function (data) {
                    window.location = data;

                },
                error: function (data) {
                    alert("Error");
                }
            });
        }, { scope: perms }); // 設定 scope(使用者同意之權限) 參數
       
    }
   
    

</script>
    <h2><%: Title %>.</h2>
      <input type="hidden" id="accessToken"/>
    <div class="row">
        <div class="col-md-8">
            <section id="loginForm">
                <div class="form-horizontal">
                    <h4>使用本機帳戶進行登入。</h4>
                    <hr />
                    <asp:PlaceHolder runat="server" ID="ErrorMessage" Visible="false">
                        <p class="text-danger">
                            <asp:Literal runat="server" ID="FailureText" />
                        </p>
                    </asp:PlaceHolder>
                    <div class="form-group">
                        <asp:Label runat="server" AssociatedControlID="Email" CssClass="col-md-2 control-label">電子郵件</asp:Label>
                        <div class="col-md-10">
                            <asp:TextBox runat="server" ID="Email" CssClass="form-control" TextMode="Email" />
                            <asp:RequiredFieldValidator runat="server" ControlToValidate="Email"
                                CssClass="text-danger" ErrorMessage="必須填寫電子郵件欄位。" />
                        </div>
                    </div>
                    <div class="form-group">
                        <asp:Label runat="server" AssociatedControlID="Password" CssClass="col-md-2 control-label">密碼</asp:Label>
                        <div class="col-md-10">
                            <asp:TextBox runat="server" ID="Password" TextMode="Password" CssClass="form-control" />
                            <asp:RequiredFieldValidator runat="server" ControlToValidate="Password" CssClass="text-danger" ErrorMessage="必須填寫密碼欄位。" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <div class="checkbox">
                                <asp:CheckBox runat="server" ID="RememberMe" />
                                <asp:Label runat="server" AssociatedControlID="RememberMe">記住我?</asp:Label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <asp:Button runat="server" OnClick="LogIn" Text="登入" CssClass="btn btn-default" />
                         <fb:login-button scope="public_profile,email,user_birthday,user_about_me,user_photos" onlogin="checkLoginState();"></fb:login-button>
                         <input type="button" id="fbLoginBtn" value="Login" onclick="loginFB();"/> 
                            <input type="button" id="btnLogout" value="Logout" onclick="Logout();">
                        </div>
                        <div id="status">
                        </div>
                          <div id="info">
                        </div>
                    </div>
                </div>
                <p>
                    <asp:HyperLink runat="server" ID="RegisterHyperLink" ViewStateMode="Disabled">以新使用者身分註冊</asp:HyperLink>
                </p>
                <p>
                    <%-- 一旦您的帳戶確認啟用了密碼重設功能請加以啟用
                    <asp:HyperLink runat="server" ID="ForgotPasswordHyperLink" ViewStateMode="Disabled">忘記密碼?</asp:HyperLink>
                    --%>
                </p>
            </section>
        </div>

        <div class="col-md-4">
            <section id="socialLoginForm">
                <uc:OpenAuthProviders runat="server" ID="OpenAuthLogin" />
            </section>
        </div>
    </div>
</asp:Content>
