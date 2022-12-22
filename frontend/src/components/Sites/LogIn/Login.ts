import {Options, Vue,} from "vue-property-decorator";
import { namespace } from "s-vuex-class";
import Component from 'vue-class-component';


const Auth = namespace("Auth");


@Options({})
export default class Login extends Vue {
    private user = {username: "", password: ""};
    private loading = false;
    private message = "";

    @Auth.Getter
    private isLoggedIn!: boolean;

    @Auth.Action
    private login!: (data: any) => Promise<any>;

    created() {
        if (this.isLoggedIn) {
            this.$router.push("/profile");
        }
    }

    handleLogin() {
        this.loading = true;
        this.$validator.validateAll().then((isValid) => {
            if (!isValid) {
                this.loading = false;
                return;
            }

            if (this.user.username && this.user.password) {
                this.login(this.user).then(
                    (data) => {
                        this.$router.push("/profile");
                    },
                    (error) => {
                        this.loading = false;
                        this.message = error;
                    }
                );
            }
        })
    }
}