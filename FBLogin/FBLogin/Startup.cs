using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(FBLogin.Startup))]
namespace FBLogin
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
