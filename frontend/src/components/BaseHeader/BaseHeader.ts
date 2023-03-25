
import { mapGetters } from 'vuex';
import store from '~/store';


export default {
  data: () => {
    return {
      isLoggedIn: store.state.token
    }
  },
}