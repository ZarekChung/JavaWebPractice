using Facebook;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FBLogin
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
          
            GetData();


        }
        private void GetData()
        {
        if (Session["AccessToken"] != null)
        {
            var accessToken = Session["AccessToken"].ToString();
            var client = new FacebookClient(accessToken);
                dynamic result = client.Get("me", new { fields = "name,id,email,last_name" });

                string id = "fb_" + result.id;
                string name = result.name;
                string mail = result.mail;
                string age_range = result.last_name;
/*
                UsersDao myDao = new UsersDao();
                bool idexist = true;
                idexist = myDao.CheckUser(id);
                if (!idexist)
                    myDao.AddNewUser(id, name, mail);
                    */
                lblLoginID.Text = id;
                lblName.Text = name;
                lblMail.Text = mail;
               lblExist.Text = age_range;
            }
        }
    }
}