package db

import org.ktorm.schema.Table
import org.ktorm.schema.*


/*uid = 1234
userName = "小"
sex = 0
birthdayDate = "2023-03-29"*/
object Demo: Table<Nothing>("demo"){
    val uid = long("id").primaryKey()
    val name= text("name")
    val sex =int("sex")
    val birthday=text("birthday")
}