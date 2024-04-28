<template>
	<div>
			<b-form-group v-if="$check_register_field('add','student_id','/ordinary_users/view')" id="input-group-${idx}" label="学号" label-for="input-${idx}">
			<b-form-input id="input-${idx}" v-model="form['student_id']" type="text" placeholder="学号" trim></b-form-input>
		</b-form-group>
				<b-form-group v-if="$check_register_field('add','full_name','/ordinary_users/view')" id="input-group-${idx}" label="姓名" label-for="input-${idx}">
			<b-form-input id="input-${idx}" v-model="form['full_name']" type="text" placeholder="姓名" trim></b-form-input>
		</b-form-group>
				<b-form-group v-if="$check_register_field('add','grade_class','/ordinary_users/view')" id="input-group-${idx}" label="年级班级" label-for="input-${idx}">
			<b-form-input id="input-${idx}" v-model="form['grade_class']" type="text" placeholder="年级班级" trim></b-form-input>
		</b-form-group>
				<b-form-group v-if="$check_register_field('add','political_outlook','/ordinary_users/view')" id="input-group-${idx}" label="政治面貌" label-for="input-${idx}">
			<b-form-select id="input-${idx}" v-model="form['political_outlook']" :options="getDropList(list_political_outlook)"></b-form-select>
		</b-form-group>
				<b-form-group v-if="$check_register_field('add','hospital','/ordinary_users/view')" id="input-group-${idx}" label="院别" label-for="input-${idx}">
			<b-form-select id="input-${idx}" v-model="form['hospital']" :options="list_hospital"></b-form-select>
		</b-form-group>
		</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		model: {
			prop: "form",
			event: "change"
		},
		props: {
			form: {
				type: Object,
				default: () => {
					return {

					}
				}
			}
		},
		data(){
			return {
				url_upload: "~/api/ordinary_users/upload?",
										        list_political_outlook: "党员,团员,群众",
					        // 院别选项列表
        list_hospital: [],
					}
		},
		methods: {
			// 下拉数据列表转换
			getDropList(e){
				let resultArr = [];
				if(e){
					let arr = e.split(",");
					arr.forEach(item => {
						resultArr.push({
							value: item,
							text: item
						})
					});
				}
				return resultArr;
			},
										      /**
       * 获取院别列表
       */
      async get_list_hospital() {
        let json = await this.$get("~/api/department_category/get_list?");
        if(json.result && json.result.list){
          this.list_hospital = [];
          json.result.list.forEach(item => {
            this.list_hospital.push({
              value: item.department_category,
              text: item.department_category
            })
          });
        }
        else if(json.error){
          console.error(json.error);
        }
      },
				/**
			 * 上传图片
			 * @param {Object} file 文件对象
			 * @param {key} 保存键名
			 */
			uploadFile(file, key = "img") {
				var _this = this;
				var form = new FormData() // FormData 对象
				form.append('file', file[0]) // 文件对象
				this.$upload(this.url_upload, form, function(json) {
					if (json.result) {
						// _this.form[key] = json.result.url;
						_this.$delete(_this.form,key);
						_this.$set(_this.form,key,json.result.url);
						console.log(_this.form[key])
					} else {
						_this.$toast('上传失败！');
					}
				});
			},
		},
    created() {
					      this.get_list_hospital();
	    },
	mounted(){
						}
	}
</script>

<style>
</style>
