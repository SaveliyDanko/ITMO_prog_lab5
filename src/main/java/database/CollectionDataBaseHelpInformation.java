package database;

/**
 * A class that contains help information of Data Base
 *
 * @since 1.0
 * @author savadanko
 */

public class CollectionDataBaseHelpInformation {
    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_PURPLE = "\u001B[35m";

    /**
     * help information message
     */
    public static final String HELP_MESSAGE = ANSI_PURPLE + "help" + ANSI_RESET + " : вывести справку по доступным командам\n" +
            ANSI_PURPLE + "info" + ANSI_RESET + " : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
            ANSI_PURPLE + "show" + ANSI_RESET + " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
            ANSI_PURPLE + "insert null {element}" + ANSI_RESET + " : добавить новый элемент с заданным ключом\n" +
            ANSI_PURPLE + "update id {element}" + ANSI_RESET + " : обновить значение элемента коллекции, id которого равен заданному\n" +
            ANSI_PURPLE + "remove_key id" + ANSI_RESET + " : удалить элемент из коллекции по его ключу\n" +
            ANSI_PURPLE + "clear" + ANSI_RESET + " : очистить коллекцию\n" +
            ANSI_PURPLE + "save" + ANSI_RESET + " : сохранить коллекцию в файл\n" +
            ANSI_PURPLE + "execute_script file_name" + ANSI_RESET + " : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
            ANSI_PURPLE + "exit" + ANSI_RESET + " : завершить программу (без сохранения в файл)\n" +
            ANSI_PURPLE + "remove_lower {element}" + ANSI_RESET + " : удалить из коллекции все элементы, меньшие, чем заданный\n" +
            ANSI_PURPLE + "history" + ANSI_RESET + " : вывести последние 12 команд (без их аргументов)\n" +
            ANSI_PURPLE + "remove_greater_key id" + ANSI_RESET + " : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
            ANSI_PURPLE + "min_by_name" + ANSI_RESET + " : вывести любой объект из коллекции, значение поля name которого является минимальным\n" +
            ANSI_PURPLE + "count_by_transport" + ANSI_RESET + " : вывести количество элементов, значение поля transport которых равно заданному\n" +
            ANSI_PURPLE + "filter_starts_with_name name" + ANSI_RESET + " : вывести элементы, значение поля name которых начинается с заданной подстроки";
}
