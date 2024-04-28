<template>
	<div>
			<el-form-item v-if="$check_register_field('add','student_id','/general_manager/view')" label="学号" prop="student_id">
				<el-input id="student_id" v-model="form['student_id']" placeholder="请输入学号"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','manager_name','/general_manager/view')" label="管理者姓名" prop="manager_name">
				<el-input id="manager_name" v-model="form['manager_name']" placeholder="请输入管理者姓名"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','number_of_sessions','/general_manager/view')" label="届数" prop="number_of_sessions">
				<el-input id="number_of_sessions" v-model="form['number_of_sessions']" placeholder="请输入届数"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','grade_class','/general_manager/view')" label="年级班级" prop="grade_class">
				<el-input id="grade_class" v-model="form['grade_class']" placeholder="请输入年级班级"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','hospital','/general_manager/view')" label="院别" prop="hospital">
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
								"manager_name":  '' ,
								"number_of_sessions":  '' ,
								"grade_class":  '' ,
								"hospital":  '' ,
						}
				}
			},

		},
		data() {
			return {
				field: "general_manager_id",
				url_add: "~/api/general_manager/add?",
				url_set: "~/api/general_manager/set?",
				url_upload: "~/api/general_manager/upload?",

									list_hospital: [""],
	
				rules: {
					"student_id": [    {required: true,message: '学号不能为空'},  ],
					"manager_name": [    {required: true,message: '管理者姓名不能为空'},  ],
					"number_of_sessions": [    {required: true,message: '届数不能为空'},  ],
					"grade_class": [    {required: true,message: '年级班级不能为空'},  ],
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
