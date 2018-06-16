export class DateUtils {

    static formatDate(date: Date) {
        return date.getDay() + '/' + date.getMonth() + '/' + date.getFullYear();
    }

}
