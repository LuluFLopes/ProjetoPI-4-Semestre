<template>
  <main>
    <div>
      <h1>Iniciar Sessão</h1>
      <form role="form" @submit.prevent="submitSignIn()">
        <fieldset>
          <div>
            <label for="userLogin">Usuário:</label>
            <input id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" v-model="formData.usuario"
                   required>
          </div>

          <div>
            <label for="userPassword">Senha:</label>
            <input id="userPassword" type="password" aria-label="Senha" placeholder="Senha" v-model="formData.senha"
                   required>
          </div>
          <button type="submit">Entrar</button>

          <div class="cadastro">
            <label>Não possui cadastro?</label>
            <router-link to="cadastro">Cadastre-se aqui!</router-link>
          </div>
        </fieldset>
      </form>
    </div>
  </main>
</template>

<script>

import {defineComponent} from "vue";
import axios from "axios";
import router from "@/router";
import CryptoJS from "crypto-js";
import {mapActions, mapMutations, mapState} from "vuex";

const url = 'http://localhost:8081/clientes/login';

export default defineComponent({
  emits: [
    'clicarBotaoEntrar'
  ],
  data() {
    return {
      formData: {
        usuario: "",
        senha: ""
      }
    }
  },
  computed: {
    ...mapState([
      'carrinho',
      'tipoDeLogin',
      'pedidoFechamento'
    ])
  },
  methods: {
    async submitSignIn() {
      let senha = this.formData.senha
      senha = this.encrypt(senha)

      try {
        this.formData.senha = senha
        const request = await axios.post(url, this.formData);
        this.getUserInfos(request.data);
        let fechamento = this.pedidoFechamento;
        fechamento.idCliente = request.data.id;
        this.setInformacoesPedidoFechamento(fechamento);

        this.setTipoDeLogin(2);
        if (this.carrinho.length === 0) {
          await router.push('/');
        } else {
          await router.push('/telaFinalizarCompra');
        }
      } catch (ex) {
        alert("Não foi possível fazer o login, verifique seus dados!");
        console.log(ex.message);
      }
    },
    encrypt(senha) {
      return CryptoJS.SHA512(senha).toString()
    },
    ...mapActions([
      'getUserInfos',
    ]),
    ...mapMutations([
      'setTipoDeLogin',
      'setInformacoesPedidoFechamento'
    ])
  },
});

</script>

<style scoped>

main {
  background-color: rgba(45, 46, 50);
  height: 100%;
  width: 100vw;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

label, p, a {
  color: rgb(6, 45, 78);
  padding: 10px;
}

h1 {
  color: aliceblue;
  font-size: 3 dvw;
}

label, input {
  padding: 10px;
  margin: 2 dvh;
  align-items: center;
  justify-content: left;
  text-align: left;
}

fieldset {
  background-color: aliceblue;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  align-items: center;
  height: 250px;
}

.cadastro {
  display: flex;
  align-items: center;
  font-size: small;
}

</style>