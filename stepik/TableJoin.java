package com.company;

import java.util.Scanner;

/**
 * Объединение таблиц
 * <p>
 * В базе данных есть n таблиц, пронумерованных от 1 до n,
 * над одним и тем же множеством столбцов (атрибутов).
 * Каждая таблица содержит либо реальные записи в таблице,
 * либо символьную ссылку на другую таблицу.
 * Изначально все таблицы содержат реальные записи, и i-я таблица содержит ri записей.
 * Ваша цель — обработать m запросов типа (destination, source).
 */

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            int tablesCounter = in.nextInt();
            int queriesCounter = in.nextInt();

            Table[] tables = new Table[tablesCounter];
            for (int i = 0; i < tablesCounter; i++) {
                tables[i] = new Table(i, in.nextInt());
            }

            Query[] queries = new Query[queriesCounter];
            for (int i = 0; i < queriesCounter; i++) {
                queries[i] = new Query(in.nextInt(), in.nextInt());
            }

            int[] maxTables = maxTablesAfterQueries(tables, queries);
            for (int maxTable : maxTables) {
                System.out.println(maxTable);
            }
        }
    }

    public static int[] maxTablesAfterQueries(Table[] tables, Query[] queries) {
        int[] result = new int[queries.length];

        int maxRecords = tables[0].recordsCounter();
        for (int i = 1; i < tables.length; i++) {
            if (tables[i].recordsCounter() > maxRecords) {
                maxRecords = tables[i].recordsCounter();
            }
        }

        for (int i = 0; i < queries.length; i++) {
            Query query = queries[i];
            Table source = tables[query.source - 1];
            Table destination = tables[query.destination - 1];
            source.join(destination);

            if (destination.recordsCounter() > maxRecords) {
                maxRecords = destination.recordsCounter();
            }

            result[i] = maxRecords;
        }

        return result;
    }

    public static class Table {

        private final int index;
        private int recordsCounter;
        private Table ref;

        public Table(int index, int recordsCounter) {
            this.index = index;
            this.recordsCounter = recordsCounter;
        }

        public int recordsCounter() {
            if (ref != null) {
                return ref.recordsCounter();
            }

            return recordsCounter;
        }

        public void join(Table destination) {
            Table realSource = realTable();
            Table realDestination = destination.realTable();

            if (realSource.index != realDestination.index) {
                realDestination.recordsCounter += realSource.recordsCounter;
                realSource.recordsCounter = 0;
                realSource.ref = realDestination;
            }
        }

        public Table realTable() {
            if (ref == null) {
                return this;
            }

            ref = ref.realTable();
            return ref;
        }
    }

    public static class Query {
        public final int destination;
        public final int source;

        public Query(int destination, int source) {
            this.destination = destination;
            this.source = source;
        }
    }
}
