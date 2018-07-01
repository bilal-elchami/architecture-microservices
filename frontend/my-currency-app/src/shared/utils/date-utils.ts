export class DateUtils {

    static formatDate(date) {
        console.log(date);
        return date.getDay() + '/' + date.getMonth() + '/' + date.getFullYear();
    }

}
