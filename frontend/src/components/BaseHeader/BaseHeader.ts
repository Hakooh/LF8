import { defineComponent } from '@vue/runtime-core';
import store from '~/store';


export default defineComponent({
  data: () => {
    return {
      isLoggedIn: store.state.token
    }
  },
});