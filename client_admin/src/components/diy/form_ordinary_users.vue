<template>
	<div>
			<el-form-item v-if="$check_register_field('add','student_id','/ordinary_users/view')" label="学号" prop="student_id">
				<el-input id="student_id" v-model="form['student_id']" placeholder="请输入学号"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','full_name','/ordinary_users/view')" label="姓名" prop="full_name">
				<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','grade_class','/ordinary_users/view')" label="年级班级" prop="grade_class">
				<el-input id="grade_class" v-model="form['grade_class']" placeholder="请输入年级班级"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','political_outlook','/ordinary_users/view')" label="政治面貌" prop="political_outlook">
				<el-select id="political_outlook" v-model="form['political_outlook']">
			<el-option v-for="o in list_political_outlook" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','hospital','/ordinary_users/view')" label="院别" prop="hospital">
				<el-select id="hospital" v-model="form['hospital']">
			<el-option v-for="o in list_hospital" :key="o.department_category" :label="o.department_category"
				:value="o.department_category">
			</el-option>
		</el-select>
				</el-form-item>
	
	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		props:{

			form:{
				type: Object,
				default: function(){
					return {
							"student_id":  '' ,
								"full_name":  '' ,
								"grade_class":  '' ,
								"political_outlook":  '' ,
								"hospital":  '' ,
						}
				}
			},

		},
		data() {
			return {
				field: "ordinary_users_id",
				url_add: "~/api/ordinary_users/add?",
				url_set: "~/api/ordinary_users/set?",
				url_upload: "~/api/ordinary_users/upload?",

								list_political_outlook: ['党员','团员','群众'],
						list_hospital: [""],
	
				rules: {
					"student_id": [    {required: true,message: '学号不能为空'},  ],
					"full_name": [    {required: true,message: '姓名不能为空'},  ],
					"grade_class": [    {required: true,message: '年级班级不能为空'},  ],
					"political_outlook": [    {required: true,message: '政治面貌不能为空'},  ],
					"hospital": [    {required: true,message: '院别不能为空'},  ],
				}

			}
		},
		methods: {

	
	
	

	
	
	

	
	
	

	
	
	

	
	
				/**
			 * 获取院别列表
			 */
			async get_list_hospital() {
				var list = await this.$get("~/api/department_category/get_list?");
				this.list_hospital = list.result.list;
			},
	

		},
		created() {
								this.get_list_hospital();
			}
	}
</script>
