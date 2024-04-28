<template>
  <footer class="page_footer">
    <div class="wrap">
      <div class="container">
        <div class="row">
          <div class="col">
            <div class="card_copyright">
              欢迎使用高校党员管理系统
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
import mixin from "@/mixins/component.js";
export default {
  mixins: [mixin],
  components: {},
  data() {
    return {
    };
  },
  methods: {},
  created() {},
};
</script>

<style scoped="scoped">

.page_footer .wrap {
  background-color: #000;
  color: white;
}
.card_copyright {
	padding: 30px 10px;
  text-align: center;
}
</style>
