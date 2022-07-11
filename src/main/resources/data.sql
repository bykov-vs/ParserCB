INSERT INTO info_type_code (code, name) VALUES('FIRR', 'Полный Справочник БИК');
INSERT INTO info_type_code (code, name)  VALUES('SIRR', 'Изменения в Справочнике БИК (содержит только изменения относительно предыдущего Справочника БИК)');

INSERT INTO creation_reason (code, name) VALUES('RQST', 'Ответ на ЭС-запрос Участника');
INSERT INTO creation_reason (code, name) VALUES('CIBD', 'Регламентное направление изменений в Справочнике БИК в течение операционного дня.');
INSERT INTO creation_reason (code, name) VALUES('FCBD', '1) Регламентное направление изменений к Справочнику БИК, формируемого в завершающем сеансе операционного дня платежной системы Банка России, актуальных со следующего операционного дня (SIRR);2) Регламентное направление из ПС СБП в ОПКЦ полного СправочникаБИК, формируемого в завершающем сеансе операционного дня платежной системы Банка России, актуального с следующего операционного дня (FIRR).');


INSERT INTO change_type (code, name) VALUES('ADDD','Запись Справочника БИК была добавлена');
INSERT INTO change_type (code, name) VALUES('CHGD','Запись Справочника БИК была изменена по сравнению с предыдущей версией Справочника(под изменением понимается любое изменение информации, относящейся к участнику. В том числе: добавление, удаление, изменение характеристик счета участника)');
INSERT INTO change_type (code, name) VALUES('DLTD','Запись Справочника БИК была удалена');

INSERT INTO pt_type (code, name) VALUES('00','Главное управление Банка России');
INSERT INTO pt_type (code, name) VALUES('10','Расчетно-кассовый центр');
INSERT INTO pt_type (code, name) VALUES('12','Отделение, отделение – национальный банк главного управления Банка России');
INSERT INTO pt_type (code, name) VALUES('15','Структурное подразделение центрального аппарата Банка России');
INSERT INTO pt_type (code, name) VALUES('16','Кассовый центр');
INSERT INTO pt_type (code, name) VALUES('20','Кредитная организация');
INSERT INTO pt_type (code, name) VALUES('30','Филиал кредитной организации');
INSERT INTO pt_type (code, name) VALUES('40','Полевое учреждение Банка России');
INSERT INTO pt_type (code, name) VALUES('51','Федеральное казначейство');
INSERT INTO pt_type (code, name) VALUES('52','Территориальный орган Федерального казначейства');
INSERT INTO pt_type (code, name) VALUES('60','Иностранный банк (иностранная кредитная организация)');
INSERT INTO pt_type (code, name) VALUES('65','Иностранный центральный (национальный) банк');
INSERT INTO pt_type (code, name) VALUES('71','Клиент кредитной организации, являющийся косвенным участником');
INSERT INTO pt_type (code, name) VALUES('75','Клиринговая организация');
INSERT INTO pt_type (code, name) VALUES('78','Внешняя платежная система');
INSERT INTO pt_type (code, name) VALUES('90','Конкурсный управляющий (ликвидатор, ликвидационная комиссия)');
INSERT INTO pt_type (code, name) VALUES('99','Клиент Банка России, не являющийся участником платежной системы');

INSERT INTO srvcs (code, name) VALUES('1','Сервис несрочного перевода');
INSERT INTO srvcs (code, name) VALUES('2','Сервис срочного перевода');
INSERT INTO srvcs (code, name) VALUES('3','Сервис несрочного перевода и сервис срочного перевода');
INSERT INTO srvcs (code, name) VALUES('4','Сервис срочного перевода и сервис быстрых платежей');
INSERT INTO srvcs (code, name) VALUES('5','Сервис срочного перевода, сервис несрочного перевода и сервис быстрых платежей');
INSERT INTO srvcs (code, name) VALUES('6','Сервис быстрых платежей');

INSERT INTO xch_type (code, name) VALUES('0','Не участник обмена');
INSERT INTO xch_type (code, name) VALUES('1','Участник обмена');

INSERT INTO rstr (code, name) VALUES('URRS','Ограничение предоставления сервиса срочного перевода');
INSERT INTO rstr (code, name) VALUES('LWRS','Отзыв (аннулирование) лицензии');
INSERT INTO rstr (code, name) VALUES('MRTR','Мораторий на удовлетворение требований кредиторов');
INSERT INTO rstr (code, name) VALUES('RSIP','Приостановление доступа к услугам по переводу денежных средств в качестве косвенного участника');
INSERT INTO rstr (code, name) VALUES('FPIP','Приостановление предоставления сервиса быстрых платежей косвенному участнику');

INSERT INTO participant_status (code, name) VALUES('PSAC','«Действующий», когда текущая дата операционного дня позднее или равна дате активации участника и ранее даты удаления Участника, если дата удаления Участника была установлена');
INSERT INTO participant_status (code, name) VALUES('PSDL','«Удаленный», если текущая дата операционного дня равна дате вступления в силу удаления Участника (направляется только в «короткой» версии ED807 содержащей только изменения в Справочнике БИК. Только в день удаления)');

INSERT INTO acc_rstr (code, name) VALUES('LMRS','Временное сохранение счета с его функционированием в ограниченном режиме');
INSERT INTO acc_rstr (code, name) VALUES('URRS','Ограничение предоставления сервиса срочного перевода ');
INSERT INTO acc_rstr (code, name) VALUES('CLRS','Закрытие счета');
INSERT INTO acc_rstr (code, name) VALUES('FPRS','Приостановление предоставления сервиса быстрых платежей');
INSERT INTO acc_rstr (code, name) VALUES('SDRS','Признак использования реквизитов филиала кредитной организации после его преобразования во внутреннее структурное подразделение (Признак ВСП)');

INSERT INTO account_status (code, name) VALUES('ACAC','«Действующий», когда текущая дата операционного дня позднее или равна дате активации счета и ранее даты удаления счета, или если дата удаления счета не была установлена');
INSERT INTO account_status (code, name) VALUES('ACDL','«Удаленный», когда текущая дата операционного дня равна дате удаления счета');

INSERT INTO regulation_account_type (code, name) VALUES('CBRA','Счет Банка России');
INSERT INTO regulation_account_type (code, name) VALUES('CRSA','Корреспондентский счет (субсчет)');
INSERT INTO regulation_account_type (code, name) VALUES('BANA','Банковский счет, не являющийся корреспондентским счетом (субсчетом) или единым казначейским счетом');
INSERT INTO regulation_account_type (code, name) VALUES('TRSA','Счет территориального органа Федерального казначейства');
INSERT INTO regulation_account_type (code, name) VALUES('TRUA','Счет доверительного управления');
INSERT INTO regulation_account_type (code, name) VALUES('CLAC','Клиринговый счет');
INSERT INTO regulation_account_type (code, name) VALUES('UTRA','Единый казначейский счет');