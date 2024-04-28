<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','student_id') || $check_field('add','student_id') || $check_field('set','student_id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学号" prop="student_id">
												<el-input id="student_id" v-model="form['student_id']" placeholder="请输入学号"
							  v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','student_id')) || (!form['party_member_information_id'] && $check_field('add','student_id'))" :disabled="disabledObj['student_id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_id')">{{form['student_id']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
												<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','full_name')) || (!form['party_member_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别" prop="gender">
								<el-select id="gender" v-model="form['gender']"
						v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','gender')) || (!form['party_member_information_id'] && $check_field('add','gender'))">
						<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','grade_class') || $check_field('add','grade_class') || $check_field('set','grade_class')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年级班级" prop="grade_class">
												<el-input id="grade_class" v-model="form['grade_class']" placeholder="请输入年级班级"
							  v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','grade_class')) || (!form['party_member_information_id'] && $check_field('add','grade_class'))" :disabled="disabledObj['grade_class_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','grade_class')">{{form['grade_class']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','identity') || $check_field('add','identity') || $check_field('set','identity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份" prop="identity">
								<el-select id="identity" v-model="form['identity']"
						v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','identity')) || (!form['party_member_information_id'] && $check_field('add','identity'))">
						<el-option v-for="o in list_identity" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','identity')">{{form['identity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','hospital') || $check_field('add','hospital') || $check_field('set','hospital')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="院别" prop="hospital">
								<el-select id="hospital" v-model="form['hospital']"
						v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','hospital')) || (!form['party_member_information_id'] && $check_field('add','hospital'))">
						<el-option v-for="o in list_hospital" :key="o['department_category']" :label="o['department_category']"
							:value="o['department_category']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','hospital')">{{form['hospital']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','personal_portrait') || $check_field('add','personal_portrait') || $check_field('set','personal_portrait')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="个人头像" prop="personal_portrait">
								<el-upload :disabled="disabledObj['personal_portrait_isDisabled']" id="personal_portrait" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_personal_portrait"
						:show-file-list="false" v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','personal_portrait')) || (!form['party_member_information_id'] && $check_field('add','personal_portrait'))">
						<img v-if="form['personal_portrait']" :src="$fullUrl(form['personal_portrait'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','personal_portrait')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['personal_portrait'])" :preview-src-list="[$fullUrl(form['personal_portrait'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','id_number') || $check_field('add','id_number') || $check_field('set','id_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证号" prop="id_number">
												<el-input id="id_number" v-model="form['id_number']" placeholder="请输入身份证号"
							  v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','id_number')) || (!form['party_member_information_id'] && $check_field('add','id_number'))" :disabled="disabledObj['id_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id_number')">{{form['id_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_active_members_of_the_party') || $check_field('add','number_of_active_members_of_the_party') || $check_field('set','number_of_active_members_of_the_party')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="入党积极分子期数" prop="number_of_active_members_of_the_party">
												<el-input id="number_of_active_members_of_the_party" v-model="form['number_of_active_members_of_the_party']" placeholder="请输入入党积极分子期数"
							  v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','number_of_active_members_of_the_party')) || (!form['party_member_information_id'] && $check_field('add','number_of_active_members_of_the_party'))" :disabled="disabledObj['number_of_active_members_of_the_party_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','number_of_active_members_of_the_party')">{{form['number_of_active_members_of_the_party']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','when_to_become_a_probationary_member') || $check_field('add','when_to_become_a_probationary_member') || $check_field('set','when_to_become_a_probationary_member')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="何时转为预备党员" prop="when_to_become_a_probationary_member">
												<el-input id="when_to_become_a_probationary_member" v-model="form['when_to_become_a_probationary_member']" placeholder="请输入何时转为预备党员"
							  v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','when_to_become_a_probationary_member')) || (!form['party_member_information_id'] && $check_field('add','when_to_become_a_probationary_member'))" :disabled="disabledObj['when_to_become_a_probationary_member_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','when_to_become_a_probationary_member')">{{form['when_to_become_a_probationary_member']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','when_to_become_a_full_member') || $check_field('add','when_to_become_a_full_member') || $check_field('set','when_to_become_a_full_member')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="何时转为正式党员" prop="when_to_become_a_full_member">
												<el-input id="when_to_become_a_full_member" v-model="form['when_to_become_a_full_member']" placeholder="请输入何时转为正式党员"
							  v-if="user_group === '管理员' || (form['party_member_information_id'] && $check_field('set','when_to_become_a_full_member')) || (!form['party_member_information_id'] && $check_field('add','when_to_become_a_full_member'))" :disabled="disabledObj['when_to_become_a_full_member_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','when_to_become_a_full_member')">{{form['when_to_become_a_full_member']}}</div>
											</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "party_member_information_id",
				url_add: "~/api/party_member_information/add?",
				url_set: "~/api/party_member_information/set?",
				url_get_obj: "~/api/party_member_information/get_obj?",
				url_upload: "~/api/party_member_information/upload?",

				query: {
					"party_member_information_id": 0,
				},

				form: {
								"student_id":  '', // 学号
										"full_name":  '', // 姓名
										"gender":  '', // 性别
										"grade_class":  '', // 年级班级
										"identity":  '', // 身份
										"hospital":  '', // 院别
										"personal_portrait":  '', // 个人头像
										"id_number":  '', // 身份证号
										"number_of_active_members_of_the_party":  '', // 入党积极分子期数
										"when_to_become_a_probationary_member":  '', // 何时转为预备党员
										"when_to_become_a_full_member":  '', // 何时转为正式党员
											"party_member_information_id": 0, // ID
						
				},
				disabledObj:{
								"student_id_isDisabled": false,
										"full_name_isDisabled": false,
										"gender_isDisabled": false,
										"grade_class_isDisabled": false,
										"identity_isDisabled": false,
										"hospital_isDisabled": false,
										"personal_portrait_isDisabled": false,
										"id_number_isDisabled": false,
										"number_of_active_members_of_the_party_isDisabled": false,
										"when_to_become_a_probationary_member_isDisabled": false,
										"when_to_become_a_full_member_isDisabled": false,
										},

	
		
						// 性别选项列表
				list_gender: ['男','女'],
	
		
						// 身份选项列表
				list_identity: ['正式党员','预备党员','入党积极分子'],
	
						// 院别选项列表
				list_hospital: [""],
	
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
				/**
			 * 获取院别列表
			 */
			async get_list_hospital() {
				var json = await this.$get("~/api/department_category/get_list?");
				if(json.result && json.result.list){
					this.list_hospital = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
						/**
			 * 上传个人头像
			 * @param {Object} param 图片参数
			 */
			upload_personal_portrait(param){
						this.uploadFile(param.file, "personal_portrait");
					},
	
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																						
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																										$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																																	

			},


			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/party_member_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/party_member_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/party_member_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/party_member_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/party_member_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
														this.get_list_hospital();
														},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
