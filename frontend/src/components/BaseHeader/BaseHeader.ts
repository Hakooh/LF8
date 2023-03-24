
import { mapGetters } from 'vuex';
import store from 'G:/Own_Projects/Schule_Lernfeld_8/LF8/frontend/src/store';



export default {
  data: () => {
    return {
      isLoggedIn: store.state.token
    }
  },
}