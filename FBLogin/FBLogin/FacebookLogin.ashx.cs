using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FBLogin
{
    /// <summary>
    /// FacebookLogin 的摘要描述
    /// </summary>
    public class FacebookLogin : IHttpHandler, System.Web.SessionState.IRequiresSessionState
    {

        public void ProcessRequest(HttpContext context)
        {
            var accessToken = context.Request["accessToken"];
            context.Session["AccessToken"] = accessToken;
            context.Response.ContentType = "text/plain";
            context.Response.Write("../Default.aspx");

        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
    }
}